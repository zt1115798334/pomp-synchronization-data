package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceBriefingArticle;
import com.example.pompsynchronizationdata.source.service.SourceBriefingArticleService;
import com.example.pompsynchronizationdata.target.entity.TargetBriefingArticle;
import com.example.pompsynchronizationdata.target.service.TargetBriefingArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 13:37
 * description:
 */
@Component
public class BriefingArticleCurrencyCopy extends PageHandler<SourceBriefingArticle> {

    @Autowired
    private SourceBriefingArticleService sourceBriefingArticleService;

    @Autowired
    private TargetBriefingArticleService targetBriefingArticleService;

    @Override
    protected int handleDataOfPerPage(List<SourceBriefingArticle> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceBriefingArticle sourceBriefingArticle = list.get(i);
            Long sourceBriefingArticleBriefingId = sourceBriefingArticle.getId().getBriefingId();
            String sourceBriefingArticleArticleId = sourceBriefingArticle.getId().getArticleId();
            LocalDateTime sourceBriefingArticleTime = sourceBriefingArticle.getTime();
            Long sourceBriefingArticleInsertType = sourceBriefingArticle.getInsertType();


            TargetBriefingArticle targetBriefingArticle = new TargetBriefingArticle();
            targetBriefingArticle.setBriefingId(sourceBriefingArticleBriefingId);
            targetBriefingArticle.setArticleId(sourceBriefingArticleArticleId);
            targetBriefingArticle.setCreatedTime(sourceBriefingArticleTime);
            targetBriefingArticle.setTemplateType(SysConst.TemplateType.CURRENCY_EDITION.getCode());
            targetBriefingArticle.setTemplateNumber(SysConst.TemplateNumber.CURRENCY_EDITION_2.getCode());

            targetBriefingArticleService.save(targetBriefingArticle);
        }
        return size;
    }

    @Override
    protected Page<SourceBriefingArticle> getPageList(int pageNumber) {
        return sourceBriefingArticleService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

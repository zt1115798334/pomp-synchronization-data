package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceSpeechArticle;
import com.example.pompsynchronizationdata.source.service.SourceSpeechArticleService;
import com.example.pompsynchronizationdata.target.entity.TargetBriefing;
import com.example.pompsynchronizationdata.target.entity.TargetBriefingArticle;
import com.example.pompsynchronizationdata.target.service.TargetBriefingArticleService;
import com.example.pompsynchronizationdata.target.service.TargetBriefingService;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 11:18
 * description:
 */
@Component
public class BriefingArticleMediaCopy extends PageHandler<SourceSpeechArticle> {

    @Autowired
    private SourceSpeechArticleService sourceSpeechArticleService;

    @Autowired
    private TargetBriefingService targetBriefingService;

    @Autowired
    private TargetBriefingArticleService targetBriefingArticleService;

    @Override
    protected int handleDataOfPerPage(List<SourceSpeechArticle> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceSpeechArticle sourceSpeechArticle = list.get(i);

            Long sourceSpeechArticleBriefingId = sourceSpeechArticle.getBriefingId();
            Optional<TargetBriefing> briefingOptional = targetBriefingService.findById(sourceSpeechArticleBriefingId);
            if (briefingOptional.isPresent()) {

                String sourceSpeechArticleArticleId = sourceSpeechArticle.getArticleId();
                LocalDateTime sourceSpeechArticleTime = sourceSpeechArticle.getTime();
                String sourceSpeechArticleTemplateType = sourceSpeechArticle.getTemplateType();
                String sourceSpeechArticleSpeechInfoType = sourceSpeechArticle.getSpeechInfoType();
                Integer sourceSpeechArticleDeleteState = sourceSpeechArticle.getDeleteState();


                if (sourceSpeechArticleDeleteState == 0) {//未删除
                    Integer templateNumber = null;
                    if (Objects.equal(sourceSpeechArticleSpeechInfoType, "1")) {//新闻舆情
                        templateNumber = SysConst.TemplateNumber.MEDIA_EDITION_0.getCode();
                    }
                    if (Objects.equal(sourceSpeechArticleSpeechInfoType, "2")) {//两微舆情
                        templateNumber = SysConst.TemplateNumber.MEDIA_EDITION_1.getCode();
                    }
                    if (Objects.equal(sourceSpeechArticleSpeechInfoType, "3")) {//论坛舆情
                        templateNumber = SysConst.TemplateNumber.MEDIA_EDITION_2.getCode();
                    }
                    if (Objects.equal(sourceSpeechArticleSpeechInfoType, "4")) {//纸媒舆情
                        templateNumber = SysConst.TemplateNumber.MEDIA_EDITION_3.getCode();
                    }

                    TargetBriefingArticle targetBriefingArticle = new TargetBriefingArticle();
                    targetBriefingArticle.setBriefingId(sourceSpeechArticleBriefingId);
                    targetBriefingArticle.setArticleId(sourceSpeechArticleArticleId);
                    targetBriefingArticle.setCreatedTime(sourceSpeechArticleTime);
                    targetBriefingArticle.setTemplateType(SysConst.TemplateType.MEDIA_EDITION.getCode());
                    targetBriefingArticle.setTemplateNumber(templateNumber);

                    targetBriefingArticleService.save(targetBriefingArticle);
                }
            }
        }
        return size;
    }

    @Override
    protected Page<SourceSpeechArticle> getPageList(int pageNumber) {
        return sourceSpeechArticleService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

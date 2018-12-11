package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceArticle;
import com.example.pompsynchronizationdata.source.service.SourceArticleService;
import com.example.pompsynchronizationdata.target.entity.TargetArticle;
import com.example.pompsynchronizationdata.target.service.TargetArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 9:55
 * description:
 */
@Component
public class ArticleCopy extends PageHandler<SourceArticle> {

    @Autowired
    private SourceArticleService sourceArticleService;

    @Autowired
    private TargetArticleService targetArticleService;

    @Override
    protected int handleDataOfPerPage(List<SourceArticle> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceArticle sourceArticle = list.get(i);
            String sourceArticleId = sourceArticle.getId();
            String sourceArticleRelId = sourceArticle.getRelId();
            Integer sourceArticleRegion = sourceArticle.getRegion();
            String sourceArticleCarrie = sourceArticle.getCarrie();
            String sourceArticleSiteName = sourceArticle.getSiteName();
            LocalDateTime sourceArticleCreateTime = sourceArticle.getCreateTime();
            LocalDateTime sourceArticleGatherTime = sourceArticle.getGatherTime();
            LocalDateTime sourceArticlePublishTime = sourceArticle.getPublishTime();
            String sourceArticleUrlMain = sourceArticle.getUrlMain();
            String sourceArticleUrl = sourceArticle.getUrl();
            String sourceArticleAuthor = sourceArticle.getAuthor();
            String sourceArticleFromC = sourceArticle.getFromC();
            Long sourceArticleViewC = sourceArticle.getViewC();
            Long sourceArticleCommentC = sourceArticle.getCommentC();
            Integer sourceArticleIsRelated = sourceArticle.getIsRelated();
            Integer sourceArticleIsOpinion = sourceArticle.getIsOpinion();
            String sourceArticleEmotion = sourceArticle.getEmotion();
            String sourceArticleOssPath = sourceArticle.getOssPath();
            String sourceArticleTitle = sourceArticle.getTitle();
            String sourceArticleCleanTitle = sourceArticle.getCleanTitle();
            Long sourceArticleContentWords = sourceArticle.getContentWords();
            String sourceArticleSummary = sourceArticle.getSummary();
            String sourceArticleContent = sourceArticle.getContent();
            String sourceArticleUnRelatedUserId = sourceArticle.getUnRelatedUserId();
            String sourceArticleReadUserId = sourceArticle.getReadUserId();


            TargetArticle targetArticle = new TargetArticle();
            targetArticle.setId(sourceArticleId);
            targetArticle.setRelId(sourceArticleRelId);
            targetArticle.setRegion(sourceArticleRegion);
            targetArticle.setCarrie(Integer.valueOf(sourceArticleCarrie));
            targetArticle.setSiteName(sourceArticleSiteName);
            targetArticle.setCreateTime(sourceArticleCreateTime);
            targetArticle.setGatherTime(sourceArticleGatherTime);
            targetArticle.setPublishTime(sourceArticlePublishTime);
            targetArticle.setUrlMain(sourceArticleUrlMain);
            targetArticle.setUrl(sourceArticleUrl);
            targetArticle.setAuthor(sourceArticleAuthor);
            targetArticle.setFromC(sourceArticleFromC);
            targetArticle.setViewC(sourceArticleViewC);
            targetArticle.setCommentC(sourceArticleCommentC);
            targetArticle.setIsRelated(sourceArticleIsRelated);
            targetArticle.setIsOpinion(sourceArticleIsOpinion);
            targetArticle.setEmotion(sourceArticleEmotion);
            targetArticle.setOssPath(sourceArticleOssPath);
            targetArticle.setTitle(sourceArticleTitle);
            targetArticle.setCleanTitle(sourceArticleCleanTitle);
            targetArticle.setContentWords(sourceArticleContentWords);
            targetArticle.setSummary(sourceArticleSummary);
            targetArticle.setContent(sourceArticleContent);
            targetArticle.setUnRelatedUserId(sourceArticleUnRelatedUserId);
            targetArticle.setReadUserId(sourceArticleReadUserId);
            targetArticleService.save(targetArticle);

        }
        return size;
    }

    @Override
    protected Page<SourceArticle> getPageList(int pageNumber) {
        return sourceArticleService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceCommentAnalysis;
import com.example.pompsynchronizationdata.source.service.SourceCommentAnalysisService;
import com.example.pompsynchronizationdata.target.entity.TargetCommentAnalysis;
import com.example.pompsynchronizationdata.target.service.TargetCommentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/7 16:28
 * description:
 */
@Component
public class CommentAnalysisCopy extends PageHandler<SourceCommentAnalysis> {

    @Autowired
    private SourceCommentAnalysisService sourceCommentAnalysisService;

    @Autowired
    private TargetCommentAnalysisService targetCommentAnalysisService;

    @Override
    protected int handleDataOfPerPage(List<SourceCommentAnalysis> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceCommentAnalysis sourceCommentAnalysis = list.get(i);
            Long sourceCommentAnalysisId = sourceCommentAnalysis.getId();
            String sourceCommentAnalysisWebsiteIcon = sourceCommentAnalysis.getWebsiteIcon();
            String sourceCommentAnalysisWebsiteUrl = sourceCommentAnalysis.getWebsiteUrl();
            String sourceCommentAnalysisWebsiteSource = sourceCommentAnalysis.getWebsiteSource();
            String sourceCommentAnalysisUrl = sourceCommentAnalysis.getUrl();
            String sourceCommentAnalysisUrlMd5 = sourceCommentAnalysis.getUrlMd5();
            String sourceCommentAnalysisTitle = sourceCommentAnalysis.getTitle();
            String sourceCommentAnalysisTitleClear = sourceCommentAnalysis.getTitleClear();
            Integer sourceCommentAnalysisCommentNumber = sourceCommentAnalysis.getCommentNumber();
            LocalDateTime sourceCommentAnalysisPublishTime = sourceCommentAnalysis.getPublishTime();
            LocalDateTime sourceCommentAnalysisAnalysisTime = sourceCommentAnalysis.getAnalysisTime();
            Integer sourceCommentAnalysisAnalysisState = sourceCommentAnalysis.getAnalysisState();
            Integer sourceCommentAnalysisDisplayState = sourceCommentAnalysis.getDisplayState();

            Integer showState = SysConst.ShowState.DISPLAY.getCode();
            if (sourceCommentAnalysisDisplayState != null) {
                if (sourceCommentAnalysisDisplayState == 0) { //show
                    showState = SysConst.ShowState.DISPLAY.getCode();
                }
                if (sourceCommentAnalysisDisplayState == 1) {
                    showState = SysConst.ShowState.HIDE.getCode();
                }
            }

            TargetCommentAnalysis targetCommentAnalysis = new TargetCommentAnalysis();
            targetCommentAnalysis.setId(sourceCommentAnalysisId);
            targetCommentAnalysis.setWebsiteIcon(sourceCommentAnalysisWebsiteIcon);
            targetCommentAnalysis.setWebsiteUrl(sourceCommentAnalysisWebsiteUrl);
            targetCommentAnalysis.setWebsiteSource(sourceCommentAnalysisWebsiteSource);
            targetCommentAnalysis.setUrl(sourceCommentAnalysisUrl);
            targetCommentAnalysis.setUrlMd5(sourceCommentAnalysisUrlMd5);
            targetCommentAnalysis.setTitle(sourceCommentAnalysisTitle);
            targetCommentAnalysis.setTitleClear(sourceCommentAnalysisTitleClear);
            targetCommentAnalysis.setCommentNumber(sourceCommentAnalysisCommentNumber);
            targetCommentAnalysis.setPublishTime(sourceCommentAnalysisPublishTime);
            targetCommentAnalysis.setAnalysisTime(sourceCommentAnalysisAnalysisTime);
            targetCommentAnalysis.setAnalysisState(sourceCommentAnalysisAnalysisState);
            targetCommentAnalysis.setShowState(showState);
            targetCommentAnalysisService.save(targetCommentAnalysis);
        }
        return size;
    }

    @Override
    protected Page<SourceCommentAnalysis> getPageList(int pageNumber) {
        return sourceCommentAnalysisService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

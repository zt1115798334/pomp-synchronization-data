package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceCommentAnalysisUser;
import com.example.pompsynchronizationdata.source.service.SourceCommentAnalysisUserService;
import com.example.pompsynchronizationdata.target.entity.TargetCommentAnalysisUser;
import com.example.pompsynchronizationdata.target.service.TargetCommentAnalysisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/7 16:30
 * description:
 */
@Component
public class CommentAnalysisUserCopy extends PageHandler<SourceCommentAnalysisUser> {

    @Autowired
    private SourceCommentAnalysisUserService sourceCommentAnalysisUserService;

    @Autowired
    private TargetCommentAnalysisUserService targetCommentAnalysisUserService;

    @Override
    protected int handleDataOfPerPage(List<SourceCommentAnalysisUser> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceCommentAnalysisUser sourceCommentAnalysisUser = list.get(i);
            Long sourceCommentAnalysisUserUserId = sourceCommentAnalysisUser.getUserId();
            Long sourceCommentAnalysisUserAnalysisId = sourceCommentAnalysisUser.getAnalysisId();
            String sourceCommentAnalysisUserUrlMd5 = sourceCommentAnalysisUser.getUrlMd5();
            LocalDateTime sourceCommentAnalysisUserCreatedTime = sourceCommentAnalysisUser.getCreatedTime();
            Integer sourceCommentAnalysisUserDeleteState = sourceCommentAnalysisUser.getDeleteState();


            TargetCommentAnalysisUser targetCommentAnalysisUser = new TargetCommentAnalysisUser();
            targetCommentAnalysisUser.setUserId(sourceCommentAnalysisUserUserId);
            targetCommentAnalysisUser.setAnalysisId(sourceCommentAnalysisUserAnalysisId);
            targetCommentAnalysisUser.setUrlMd5(sourceCommentAnalysisUserUrlMd5);
            targetCommentAnalysisUser.setCreatedTime(sourceCommentAnalysisUserCreatedTime);
            targetCommentAnalysisUserService.save(targetCommentAnalysisUser);
        }
        return size;
    }

    @Override
    protected Page<SourceCommentAnalysisUser> getPageList(int pageNumber) {
        return sourceCommentAnalysisUserService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

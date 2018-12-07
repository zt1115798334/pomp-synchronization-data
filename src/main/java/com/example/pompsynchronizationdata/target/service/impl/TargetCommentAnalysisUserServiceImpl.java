package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetCommentAnalysisUser;
import com.example.pompsynchronizationdata.target.repo.TargetCommentAnalysisUserRepository;
import com.example.pompsynchronizationdata.target.service.TargetCommentAnalysisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 16:15
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetCommentAnalysisUserServiceImpl implements TargetCommentAnalysisUserService {

    @Autowired
    private TargetCommentAnalysisUserRepository targetCommentAnalysisUserRepository;

    @Override
    public TargetCommentAnalysisUser save(TargetCommentAnalysisUser targetCommentAnalysisUser) {
        Optional<TargetCommentAnalysisUser> analysisUserOptional = targetCommentAnalysisUserRepository.findByUserIdAndAnalysisId(targetCommentAnalysisUser.getUserId(), targetCommentAnalysisUser.getAnalysisId());
        return analysisUserOptional.orElseGet(() -> targetCommentAnalysisUserRepository.save(targetCommentAnalysisUser));
    }
}

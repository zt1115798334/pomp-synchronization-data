package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetCommentAnalysis;
import com.example.pompsynchronizationdata.target.repo.TargetCommentAnalysisRepository;
import com.example.pompsynchronizationdata.target.service.TargetCommentAnalysisService;
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
public class TargetCommentAnalysisServiceImpl implements TargetCommentAnalysisService {

    @Autowired
    private TargetCommentAnalysisRepository targetCommentAnalysisRepository;

    @Override
    public TargetCommentAnalysis save(TargetCommentAnalysis targetCommentAnalysis) {
        Optional<TargetCommentAnalysis> commentAnalysisOptional = targetCommentAnalysisRepository.findByUrlMd5(targetCommentAnalysis.getUrlMd5());
        return commentAnalysisOptional.orElseGet(() -> targetCommentAnalysisRepository.save(targetCommentAnalysis));
    }
}

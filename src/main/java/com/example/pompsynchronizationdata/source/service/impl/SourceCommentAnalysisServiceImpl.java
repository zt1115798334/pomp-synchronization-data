package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceCommentAnalysis;
import com.example.pompsynchronizationdata.source.repo.SourceCommentAnalysisRepository;
import com.example.pompsynchronizationdata.source.service.SourceCommentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 16:24
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceCommentAnalysisServiceImpl implements SourceCommentAnalysisService {

    @Autowired
    private SourceCommentAnalysisRepository sourceCommentAnalysisRepository;

    @Override
    public Page<SourceCommentAnalysis> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceCommentAnalysisRepository.findAll(null, pageRequest);
    }
}

package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceCommentAnalysisUser;
import com.example.pompsynchronizationdata.source.repo.SourceCommentAnalysisUserRepository;
import com.example.pompsynchronizationdata.source.service.SourceCommentAnalysisUserService;
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
public class SourceCommentAnalysisUserServiceImpl implements SourceCommentAnalysisUserService {

    @Autowired
    private SourceCommentAnalysisUserRepository sourceCommentAnalysisUserRepository;

    @Override
    public Page<SourceCommentAnalysisUser> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceCommentAnalysisUserRepository.findAll(null,pageRequest);
    }
}

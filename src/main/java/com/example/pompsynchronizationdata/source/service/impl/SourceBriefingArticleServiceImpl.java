package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceBriefingArticle;
import com.example.pompsynchronizationdata.source.repo.SourceBriefingArticleRepository;
import com.example.pompsynchronizationdata.source.service.SourceBriefingArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:19
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceBriefingArticleServiceImpl implements SourceBriefingArticleService {

    @Autowired
    private SourceBriefingArticleRepository sourceBriefingArticleRepository;

    @Override
    public Page<SourceBriefingArticle> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceBriefingArticleRepository.findAll(null,pageRequest);

    }
}

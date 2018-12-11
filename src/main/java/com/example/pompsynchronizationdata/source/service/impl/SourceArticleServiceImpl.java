package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceArticle;
import com.example.pompsynchronizationdata.source.repo.SourceArticleRepository;
import com.example.pompsynchronizationdata.source.service.SourceArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 09:50
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceArticleServiceImpl implements SourceArticleService {

    @Autowired
    private SourceArticleRepository sourceArticleRepository;

    @Override
    public Page<SourceArticle> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceArticleRepository.findAll(null, pageRequest);
    }
}

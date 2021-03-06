package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceSpeechArticle;
import com.example.pompsynchronizationdata.source.repo.SourceSpeechArticleRepository;
import com.example.pompsynchronizationdata.source.service.SourceSpeechArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 11:11
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceSpeechArticleServiceImpl implements SourceSpeechArticleService {

    @Autowired
    private SourceSpeechArticleRepository sourceSpeechArticleRepository;

    @Override
    public Page<SourceSpeechArticle> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceSpeechArticleRepository.findAll(null, pageRequest);

    }
}

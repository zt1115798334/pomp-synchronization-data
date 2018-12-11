package com.example.pompsynchronizationdata.source.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceLanguageSet;
import com.example.pompsynchronizationdata.source.repo.SourceLanguageSetRepository;
import com.example.pompsynchronizationdata.source.service.SourceLanguageSetService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/05 17:19
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceLanguageSetServiceImpl implements SourceLanguageSetService {

    @Autowired
    private SourceLanguageSetRepository sourceLanguageSetRepository;

    @Override
    public Page<SourceLanguageSet> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceLanguageSetRepository.findAll(null,pageRequest);

    }
}

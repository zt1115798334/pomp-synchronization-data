package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesDefault;
import com.example.pompsynchronizationdata.source.repo.SourceOverseasSitesDefaultRepository;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:10
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceOverseasSitesDefaultServiceImpl implements SourceOverseasSitesDefaultService {

    @Autowired
    private SourceOverseasSitesDefaultRepository sourceOverseasSitesDefaultRepository;

    @Override
    public Page<SourceOverseasSitesDefault> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceOverseasSitesDefaultRepository.findAll(null, pageRequest);

    }
}

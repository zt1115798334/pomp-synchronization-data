package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSites;
import com.example.pompsynchronizationdata.source.repo.SourceOverseasSitesRepository;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesService;
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
public class SourceOverseasSitesServiceImpl implements SourceOverseasSitesService {

    @Autowired
    private SourceOverseasSitesRepository sourceOverseasSitesRepository;

    @Override
    public Page<SourceOverseasSites> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceOverseasSitesRepository.findAll(null, pageRequest);

    }
}

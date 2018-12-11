package com.example.pompsynchronizationdata.source.service.impl;


import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceSite;
import com.example.pompsynchronizationdata.source.repo.SourceSiteRepository;
import com.example.pompsynchronizationdata.source.service.SourceSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 10:36
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceSiteServiceImpl implements SourceSiteService {

    @Autowired
    private SourceSiteRepository sourceSiteRepository;

    @Override
    public Page<SourceSite> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceSiteRepository.findAll(null, pageRequest);

    }
}

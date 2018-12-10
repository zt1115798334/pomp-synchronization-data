package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesGroup;
import com.example.pompsynchronizationdata.source.repo.SourceOverseasSitesGroupRepository;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesGroupService;
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
public class SourceOverseasSitesGroupServiceImpl implements SourceOverseasSitesGroupService {

    @Autowired
    private SourceOverseasSitesGroupRepository sourceOverseasSitesGroupRepository;

    @Override
    public Page<SourceOverseasSitesGroup> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceOverseasSitesGroupRepository.findAll(null, pageRequest);

    }
}

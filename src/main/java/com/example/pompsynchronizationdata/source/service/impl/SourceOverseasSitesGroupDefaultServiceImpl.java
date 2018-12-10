package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesGroupDefault;
import com.example.pompsynchronizationdata.source.repo.SourceOverseasSitesGroupDefaultRepository;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesGroupDefaultService;
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
public class SourceOverseasSitesGroupDefaultServiceImpl implements SourceOverseasSitesGroupDefaultService {

    @Autowired
    private SourceOverseasSitesGroupDefaultRepository sourceOverseasSitesGroupDefaultRepository;

    @Override
    public Page<SourceOverseasSitesGroupDefault> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceOverseasSitesGroupDefaultRepository.findAll(null, pageRequest);

    }
}

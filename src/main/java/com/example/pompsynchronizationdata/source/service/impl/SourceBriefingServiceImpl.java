package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceBriefing;
import com.example.pompsynchronizationdata.source.repo.SourceBriefingRepository;
import com.example.pompsynchronizationdata.source.service.SourceBriefingService;
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
public class SourceBriefingServiceImpl implements SourceBriefingService {

    @Autowired
    private SourceBriefingRepository sourceBriefingRepository;

    @Override
    public Page<SourceBriefing> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceBriefingRepository.findAll(null,pageRequest);

    }
}

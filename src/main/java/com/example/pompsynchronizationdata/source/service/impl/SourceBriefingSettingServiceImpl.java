package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceBriefingSetting;
import com.example.pompsynchronizationdata.source.repo.SourceBriefingSettingRepository;
import com.example.pompsynchronizationdata.source.service.SourceBriefingSettingService;
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
public class SourceBriefingSettingServiceImpl implements SourceBriefingSettingService {

    @Autowired
    private SourceBriefingSettingRepository sourceBriefingSettingRepository;

    @Override
    public Page<SourceBriefingSetting> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceBriefingSettingRepository.findAll(null, pageRequest);

    }
}

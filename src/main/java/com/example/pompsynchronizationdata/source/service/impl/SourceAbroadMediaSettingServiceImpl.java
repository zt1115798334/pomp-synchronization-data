package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceAbroadMediaSetting;
import com.example.pompsynchronizationdata.source.repo.SourceAbroadMediaSettingRepository;
import com.example.pompsynchronizationdata.source.service.SourceAbroadMediaSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:19
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceAbroadMediaSettingServiceImpl implements SourceAbroadMediaSettingService {

    @Autowired
    private SourceAbroadMediaSettingRepository sourceAbroadMediaSettingRepository;

    @Override
    public Page<SourceAbroadMediaSetting> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceAbroadMediaSettingRepository.findAll(null, pageRequest);
    }
}

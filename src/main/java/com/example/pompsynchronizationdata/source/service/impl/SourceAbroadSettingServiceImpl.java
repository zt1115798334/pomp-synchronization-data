package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceAbroadSetting;
import com.example.pompsynchronizationdata.source.repo.SourceAbroadSettingRepository;
import com.example.pompsynchronizationdata.source.service.SourceAbroadSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:32
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceAbroadSettingServiceImpl implements SourceAbroadSettingService {

    @Autowired
    private SourceAbroadSettingRepository sourceAbroadSettingRepository;

    @Override
    public Page<SourceAbroadSetting> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceAbroadSettingRepository.findAll(null, pageRequest);

    }
}

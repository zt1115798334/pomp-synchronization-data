package com.example.pompsynchronizationdata.target.service.impl;


import com.example.pompsynchronizationdata.target.entity.TargetUserConfig;
import com.example.pompsynchronizationdata.target.repo.TargetUserConfigRepository;
import com.example.pompsynchronizationdata.target.service.TargetUserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/12 14:45
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetUserConfigServiceImpl implements TargetUserConfigService {

    @Autowired
    private TargetUserConfigRepository targetUserConfigRepository;

    @Override
    public TargetUserConfig save(TargetUserConfig targetUserConfig) {
        return targetUserConfigRepository.save(targetUserConfig);
    }
}

package com.example.pompsynchronizationdata.target.service.impl;


import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.target.entity.TargetUser;
import com.example.pompsynchronizationdata.target.entity.TargetUserConfig;
import com.example.pompsynchronizationdata.target.repo.TargetUserConfigRepository;
import com.example.pompsynchronizationdata.target.service.TargetUserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
    public void save(Long userId) {
        Optional<TargetUserConfig> userConfigOptional = targetUserConfigRepository.findByUserId(userId);
        if (!userConfigOptional.isPresent()) {
            TargetUserConfig userConfig = new TargetUserConfig();
            userConfig.setUserId(userId);
            userConfig.setWarningAppState(ON);
            userConfig.setIndexChartSourceSpecialId(SysConst.INDEX_CHART_SOURCE_ALL);
            userConfig.setAbroadWebsiteDefaultShowState(SysConst.ShowState.DISPLAY.getCode());
            targetUserConfigRepository.save(userConfig);
        }
    }
}

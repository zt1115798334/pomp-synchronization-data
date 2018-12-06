package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetBriefingSetting;
import com.example.pompsynchronizationdata.target.repo.TargetBriefingSettingRepository;
import com.example.pompsynchronizationdata.target.service.TargetBriefingSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetBriefingSettingServiceImpl implements TargetBriefingSettingService {

    @Autowired
    private TargetBriefingSettingRepository targetBriefingSettingRepository;

    @Override
    public TargetBriefingSetting save(TargetBriefingSetting targetBriefingSetting) {
        return targetBriefingSettingRepository.save(targetBriefingSetting);
    }

    @Override
    public List<TargetBriefingSetting> findByUserId(Long userId) {
        return targetBriefingSettingRepository.findByuserId(userId);
    }
}

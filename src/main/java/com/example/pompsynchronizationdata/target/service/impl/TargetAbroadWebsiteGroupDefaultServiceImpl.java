package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsiteGroupDefault;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadWebsiteGroupDefaultRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteGroupDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:20
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetAbroadWebsiteGroupDefaultServiceImpl implements TargetAbroadWebsiteGroupDefaultService {

    @Autowired
    private TargetAbroadWebsiteGroupDefaultRepository targetAbroadWebsiteGroupDefaultRepository;

    @Override
    public TargetAbroadWebsiteGroupDefault save(TargetAbroadWebsiteGroupDefault targetAbroadWebsiteGroupDefault) {
        return targetAbroadWebsiteGroupDefaultRepository.save(targetAbroadWebsiteGroupDefault);
    }
}

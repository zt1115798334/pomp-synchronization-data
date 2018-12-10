package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadSocializationGroup;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadSocializationGroupRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadSocializationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:13
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetAbroadSocializationGroupServiceImpl implements TargetAbroadSocializationGroupService {

    @Autowired
    private TargetAbroadSocializationGroupRepository targetAbroadSocializationGroupRepository;

    @Override
    public TargetAbroadSocializationGroup save(TargetAbroadSocializationGroup targetAbroadSocializationGroup) {
        return targetAbroadSocializationGroupRepository.save(targetAbroadSocializationGroup);
    }
}

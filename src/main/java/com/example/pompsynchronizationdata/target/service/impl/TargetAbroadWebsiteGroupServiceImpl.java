package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsiteGroup;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadWebsiteGroupRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:20
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetAbroadWebsiteGroupServiceImpl implements TargetAbroadWebsiteGroupService {

    @Autowired
    private TargetAbroadWebsiteGroupRepository targetAbroadWebsiteGroupRepository;

    @Override
    public TargetAbroadWebsiteGroup save(TargetAbroadWebsiteGroup targetAbroadWebsiteGroup) {
        Optional<TargetAbroadWebsiteGroup> websiteGroupOptional = targetAbroadWebsiteGroupRepository.findByUserIdAndName(targetAbroadWebsiteGroup.getUserId(), targetAbroadWebsiteGroup.getName());
        return websiteGroupOptional.orElseGet(() -> targetAbroadWebsiteGroupRepository.save(targetAbroadWebsiteGroup));
    }
}

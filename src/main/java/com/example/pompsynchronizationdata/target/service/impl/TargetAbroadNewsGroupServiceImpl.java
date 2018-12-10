package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadNewsGroup;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadNewsGroupRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadNewsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:19
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetAbroadNewsGroupServiceImpl implements TargetAbroadNewsGroupService {

    @Autowired
    private TargetAbroadNewsGroupRepository targetAbroadNewsGroupRepository;

    @Override
    public TargetAbroadNewsGroup save(TargetAbroadNewsGroup targetAbroadNewsGroup) {
        return targetAbroadNewsGroupRepository.save(targetAbroadNewsGroup);
    }

    @Override
    public Optional<TargetAbroadNewsGroup> findByUserId(Long userId) {
        return targetAbroadNewsGroupRepository.findByUserId(userId);
    }
}

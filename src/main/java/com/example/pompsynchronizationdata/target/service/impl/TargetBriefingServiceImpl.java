package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetBriefing;
import com.example.pompsynchronizationdata.target.repo.TargetBriefingRepository;
import com.example.pompsynchronizationdata.target.service.TargetBriefingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetBriefingServiceImpl implements TargetBriefingService {

    @Autowired
    private TargetBriefingRepository targetBriefingRepository;

    @Override
    public TargetBriefing save(TargetBriefing targetBriefing) {
        return targetBriefingRepository.save(targetBriefing);
    }
}

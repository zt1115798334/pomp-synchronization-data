package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetEvent;
import com.example.pompsynchronizationdata.target.repo.TargetEventRepository;
import com.example.pompsynchronizationdata.target.service.TargetEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 15:55
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetEventServiceImpl implements TargetEventService {

    @Autowired
    private TargetEventRepository targetEventRepository;

    @Override
    public TargetEvent save(TargetEvent targetEvent) {
        return targetEventRepository.save(targetEvent);
    }
}

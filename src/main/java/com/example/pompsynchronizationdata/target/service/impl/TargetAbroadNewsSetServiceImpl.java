package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadNewsSet;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadNewsSetRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadNewsSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:19
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetAbroadNewsSetServiceImpl implements TargetAbroadNewsSetService {

    @Autowired
    private TargetAbroadNewsSetRepository targetAbroadNewsSetRepository;

    @Override
    public TargetAbroadNewsSet save(TargetAbroadNewsSet targetAbroadNewsSet) {
        return null;
    }
}

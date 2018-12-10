package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadSocializationSet;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadSocializationSetRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadSocializationSetService;
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
public class TargetAbroadSocializationSetServiceImpl implements TargetAbroadSocializationSetService {

    @Autowired
    private TargetAbroadSocializationSetRepository targetAbroadSocializationSetRepository;

    @Override
    public TargetAbroadSocializationSet save(TargetAbroadSocializationSet targetAbroadSocializationSet) {
        return targetAbroadSocializationSetRepository.save(targetAbroadSocializationSet);
    }
}

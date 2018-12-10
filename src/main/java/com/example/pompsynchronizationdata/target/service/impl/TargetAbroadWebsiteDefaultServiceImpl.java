package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsiteDefault;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadWebsiteDefaultRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteDefaultService;
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
public class TargetAbroadWebsiteDefaultServiceImpl implements TargetAbroadWebsiteDefaultService {

    @Autowired
    private TargetAbroadWebsiteDefaultRepository targetAbroadWebsiteDefaultRepository;

    @Override
    public TargetAbroadWebsiteDefault save(TargetAbroadWebsiteDefault targetAbroadWebsiteDefault) {
        return targetAbroadWebsiteDefaultRepository.save(targetAbroadWebsiteDefault);
    }
}

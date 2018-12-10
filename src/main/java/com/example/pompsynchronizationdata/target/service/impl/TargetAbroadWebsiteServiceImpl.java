package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsite;
import com.example.pompsynchronizationdata.target.repo.TargetAbroadWebsiteRepository;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteService;
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
public class TargetAbroadWebsiteServiceImpl implements TargetAbroadWebsiteService {

    @Autowired
    private TargetAbroadWebsiteRepository targetAbroadWebsiteRepository;

    @Override
    public TargetAbroadWebsite save(TargetAbroadWebsite targetAbroadWebsite) {
        return targetAbroadWebsiteRepository.save(targetAbroadWebsite);
    }
}

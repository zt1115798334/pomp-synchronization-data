package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetSite;
import com.example.pompsynchronizationdata.target.repo.TargetSiteRepository;
import com.example.pompsynchronizationdata.target.service.TargetSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 11:06
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetSiteServiceImpl implements TargetSiteService {

    @Autowired
    private TargetSiteRepository targetSiteRepository;

    @Override
    public TargetSite save(TargetSite targetSite) {
        return targetSiteRepository.save(targetSite);
    }
}

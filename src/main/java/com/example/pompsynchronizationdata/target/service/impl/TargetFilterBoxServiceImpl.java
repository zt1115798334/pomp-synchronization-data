package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetFilterBox;
import com.example.pompsynchronizationdata.target.repo.TargetFilterBoxRepository;
import com.example.pompsynchronizationdata.target.service.TargetFilterBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 15:37
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetFilterBoxServiceImpl implements TargetFilterBoxService {

    @Autowired
    private TargetFilterBoxRepository targetFilterBoxRepository;

    @Override
    public TargetFilterBox save(TargetFilterBox targetFilterBox) {
        return targetFilterBoxRepository.save(targetFilterBox);
    }
}

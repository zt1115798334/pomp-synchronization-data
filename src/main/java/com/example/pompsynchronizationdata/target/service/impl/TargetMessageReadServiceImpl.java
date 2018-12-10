package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetMessageRead;
import com.example.pompsynchronizationdata.target.repo.TargetMessageReadRepository;
import com.example.pompsynchronizationdata.target.service.TargetMessageReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:10
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetMessageReadServiceImpl implements TargetMessageReadService {

    @Autowired
    private TargetMessageReadRepository targetMessageReadRepository;

    @Override
    public TargetMessageRead save(TargetMessageRead targetMessageRead) {
        return targetMessageReadRepository.save(targetMessageRead);
    }
}

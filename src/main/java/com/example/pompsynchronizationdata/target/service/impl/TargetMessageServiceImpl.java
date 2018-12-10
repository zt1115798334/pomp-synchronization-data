package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetMessage;
import com.example.pompsynchronizationdata.target.repo.TargetMessageRepository;
import com.example.pompsynchronizationdata.target.service.TargetMessageService;
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
public class TargetMessageServiceImpl implements TargetMessageService {

    @Autowired
    private TargetMessageRepository targetMessageRepository;

    @Override
    public TargetMessage save(TargetMessage targetMessage) {
        return targetMessageRepository.save(targetMessage);
    }
}

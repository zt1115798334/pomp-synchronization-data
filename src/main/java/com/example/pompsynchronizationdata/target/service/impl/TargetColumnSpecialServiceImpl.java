package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetColumnSpecial;
import com.example.pompsynchronizationdata.target.repo.TargetColumnSpecialRepository;
import com.example.pompsynchronizationdata.target.service.TargetColumnSpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 17:41
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetColumnSpecialServiceImpl implements TargetColumnSpecialService {

    @Autowired
    private TargetColumnSpecialRepository targetColumnSpecialRepository;

    @Override
    public TargetColumnSpecial save(TargetColumnSpecial targetColumnSpecial) {
        return targetColumnSpecialRepository.save(targetColumnSpecial);
    }
}

package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetColumn;
import com.example.pompsynchronizationdata.target.repo.TargetColumnRepository;
import com.example.pompsynchronizationdata.target.service.TargetColumnService;
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
public class TargetColumnServiceImpl implements TargetColumnService {

    @Autowired
    private TargetColumnRepository targetColumnRepository;

    @Override
    public TargetColumn save(TargetColumn targetColumn) {
        return targetColumnRepository.save(targetColumn);
    }
}

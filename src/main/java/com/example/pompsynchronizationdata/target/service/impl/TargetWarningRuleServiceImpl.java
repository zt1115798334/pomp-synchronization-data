package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.target.entity.TargetWarningRule;
import com.example.pompsynchronizationdata.target.repo.TargetWarningRuleRepository;
import com.example.pompsynchronizationdata.target.service.TargetWarningRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:59
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetWarningRuleServiceImpl implements TargetWarningRuleService {

    @Autowired
    private TargetWarningRuleRepository targetWarningRuleRepository;

    @Override
    public TargetWarningRule save(TargetWarningRule targetWarningRule) {
        return targetWarningRuleRepository.save(targetWarningRule);
    }

    @Override
    public Optional<TargetWarningRule> findHandleByUserId(Long userId) {
        return targetWarningRuleRepository.findByUserIdAndWarningType(userId, SysConst.WarningType.ARTIFICIAL.getCode());
    }
}

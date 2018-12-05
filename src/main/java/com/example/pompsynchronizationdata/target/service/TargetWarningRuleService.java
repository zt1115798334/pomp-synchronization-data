package com.example.pompsynchronizationdata.target.service;

import com.example.pompsynchronizationdata.base.service.BaseService;
import com.example.pompsynchronizationdata.target.entity.TargetWarningRule;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:59
 * description:
 */
public interface TargetWarningRuleService extends BaseService<TargetWarningRule> {

    Optional<TargetWarningRule> findHandleByUserId(Long userId);
}

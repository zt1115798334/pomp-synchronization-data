package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceWarningRule;
import com.example.pompsynchronizationdata.source.repo.SourceWarningRuleRepository;
import com.example.pompsynchronizationdata.source.service.SourceWarningRuleService;
import com.example.pompsynchronizationdata.target.entity.TargetWarningRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:53
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceWarningRuleServiceImpl implements SourceWarningRuleService {

    @Autowired
    private SourceWarningRuleRepository sourceWarningRuleRepository;

    @Override
    public Page<SourceWarningRule> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceWarningRuleRepository.findAll(null, pageRequest);
    }
}

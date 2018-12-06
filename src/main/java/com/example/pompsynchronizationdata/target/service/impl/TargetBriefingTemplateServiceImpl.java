package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetBriefingTemplate;
import com.example.pompsynchronizationdata.target.repo.TargetBriefingTemplateRepository;
import com.example.pompsynchronizationdata.target.service.TargetBriefingTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetBriefingTemplateServiceImpl implements TargetBriefingTemplateService {

    @Autowired
    private TargetBriefingTemplateRepository targetBriefingTemplateRepository;

    @Override
    public TargetBriefingTemplate save(TargetBriefingTemplate targetBriefingTemplate) {
        return targetBriefingTemplateRepository.save(targetBriefingTemplate);
    }

    @Override
    public Iterable<TargetBriefingTemplate> saveAll(Iterable<TargetBriefingTemplate> t) {
        return targetBriefingTemplateRepository.saveAll(t);
    }
}

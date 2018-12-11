package com.example.pompsynchronizationdata.target.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.target.entity.TargetLanguageGroup;
import com.example.pompsynchronizationdata.target.repo.TargetLanguageGroupRepository;
import com.example.pompsynchronizationdata.target.service.TargetLanguageGroupService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 17:24
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetLanguageGroupServiceImpl implements TargetLanguageGroupService {

    @Autowired
    private TargetLanguageGroupRepository targetLanguageGroupRepository;
    
    public TargetLanguageGroup save(TargetLanguageGroup targetLanguageGroup) {
        return targetLanguageGroupRepository.save(targetLanguageGroup);
    }
    
    public Page<TargetLanguageGroup> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return targetLanguageGroupRepository.findAll(null,pageRequest);

    }
    
    public Optional<TargetLanguageGroup> findById(Long id) {
        return targetLanguageGroupRepository.findById(id);
    }
    public Optional<TargetLanguageGroup> findByUserId(Long userId) {
    	return targetLanguageGroupRepository.findByUserId(userId);
    }

}

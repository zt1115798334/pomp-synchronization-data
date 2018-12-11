package com.example.pompsynchronizationdata.target.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.target.entity.TargetLanguageSet;
import com.example.pompsynchronizationdata.target.entity.TargetLanguages;
import com.example.pompsynchronizationdata.target.repo.TargetLanguageSetRepository;
import com.example.pompsynchronizationdata.target.service.TargetLanguageSetService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 17:24
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetLanguageSetServiceImpl implements TargetLanguageSetService {

    @Autowired
    private TargetLanguageSetRepository targetLanguageSetRepository;
    
    public TargetLanguageSet save(TargetLanguageSet targetLanguageSet) {
        return targetLanguageSetRepository.save(targetLanguageSet);
    }
    
    public Page<TargetLanguageSet> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return targetLanguageSetRepository.findAll(null,pageRequest);

    }
    
    public Optional<TargetLanguageSet> findById(Long id) {
        return targetLanguageSetRepository.findById(id);
    }

}

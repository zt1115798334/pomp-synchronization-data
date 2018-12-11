package com.example.pompsynchronizationdata.target.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.target.entity.TargetBriefing;
import com.example.pompsynchronizationdata.target.entity.TargetLanguages;
import com.example.pompsynchronizationdata.target.repo.TargetLanguagesRepository;
import com.example.pompsynchronizationdata.target.service.TargetLanguagesService;

import java.util.Optional;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 15:03
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetLanguagesServiceImpl implements TargetLanguagesService {

    @Autowired
    private TargetLanguagesRepository targetLanguagesRepository;

    public TargetLanguages save(TargetLanguages targetLanguages) {
        return targetLanguagesRepository.save(targetLanguages);
    }
    
    public Page<TargetLanguages> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return targetLanguagesRepository.findAll(null,pageRequest);

    }
    
    public Optional<TargetLanguages> findById(Long id) {
        return targetLanguagesRepository.findById(id);
    }
    public TargetLanguages findNameById(Long id) {
    	return targetLanguagesRepository.findNameById(id);
    }
}

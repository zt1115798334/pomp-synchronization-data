package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceLanguages;
import com.example.pompsynchronizationdata.source.repo.SourceLanguagesRepository;
import com.example.pompsynchronizationdata.source.service.SourceLanguagesService;
import com.example.pompsynchronizationdata.target.entity.TargetLanguageSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:19
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceLanguagesServiceImpl implements SourceLanguagesService {

    @Autowired
    private SourceLanguagesRepository sourceLanguagesRepository;

    @Override
    public Page<SourceLanguages> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceLanguagesRepository.findAll(null,pageRequest);

    }
    
    public Optional<SourceLanguages> findById(Long id) {
        return sourceLanguagesRepository.findById(id);
    }

}

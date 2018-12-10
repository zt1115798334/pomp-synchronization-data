package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceAbroadMediaGroup;
import com.example.pompsynchronizationdata.source.repo.SourceAbroadMediaGroupRepository;
import com.example.pompsynchronizationdata.source.service.SourceAbroadMediaGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:19
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceAbroadMediaGroupServiceImpl implements SourceAbroadMediaGroupService {

    @Autowired
    private SourceAbroadMediaGroupRepository sourceAbroadMediaGroupRepository;


    @Override
    public Page<SourceAbroadMediaGroup> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceAbroadMediaGroupRepository.findAll(null, pageRequest);
    }
}

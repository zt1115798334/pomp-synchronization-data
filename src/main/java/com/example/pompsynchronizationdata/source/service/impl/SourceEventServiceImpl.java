package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceEvent;
import com.example.pompsynchronizationdata.source.repo.SourceEventRepository;
import com.example.pompsynchronizationdata.source.service.SourceEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 15:39
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceEventServiceImpl implements SourceEventService {

    @Autowired
    private SourceEventRepository sourceEventRepository;

    @Override
    public Page<SourceEvent> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceEventRepository.findAll(null,pageRequest);

    }
}

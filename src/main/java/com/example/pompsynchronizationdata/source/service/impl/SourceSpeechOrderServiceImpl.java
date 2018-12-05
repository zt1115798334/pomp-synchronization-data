package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceSpeechOrder;
import com.example.pompsynchronizationdata.source.repo.SourceSpeechOrderRepository;
import com.example.pompsynchronizationdata.source.service.SourceSpeechOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:30
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceSpeechOrderServiceImpl implements SourceSpeechOrderService {

    @Autowired
    private SourceSpeechOrderRepository sourceSpeechOrderRepository;

    @Override
    public Page<SourceSpeechOrder> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceSpeechOrderRepository.findAll(null, pageRequest);

    }
}

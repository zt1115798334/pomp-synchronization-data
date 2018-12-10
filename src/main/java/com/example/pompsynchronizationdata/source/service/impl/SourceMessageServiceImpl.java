package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceMessage;
import com.example.pompsynchronizationdata.source.repo.SourceMessageRepository;
import com.example.pompsynchronizationdata.source.service.SourceMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:04
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceMessageServiceImpl implements SourceMessageService {

    @Autowired
    private SourceMessageRepository sourceMessageRepository;

    @Override
    public Page<SourceMessage> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceMessageRepository.findAll(null, pageRequest);

    }
}

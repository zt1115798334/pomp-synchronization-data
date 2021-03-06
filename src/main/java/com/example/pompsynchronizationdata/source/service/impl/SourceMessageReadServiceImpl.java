package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceMessageRead;
import com.example.pompsynchronizationdata.source.repo.SourceMessageReadRepository;
import com.example.pompsynchronizationdata.source.service.SourceMessageReadService;
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
public class SourceMessageReadServiceImpl implements SourceMessageReadService {

    @Autowired
    private SourceMessageReadRepository sourceMessageReadRepository;

    @Override
    public Page<SourceMessageRead> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceMessageReadRepository.findAll(null, pageRequest);

    }
}

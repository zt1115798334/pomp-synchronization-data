package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceWarning;
import com.example.pompsynchronizationdata.source.repo.SourceWarningRepository;
import com.example.pompsynchronizationdata.source.service.SourceWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:12
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceWarningServiceImpl implements SourceWarningService {

    @Autowired
    private SourceWarningRepository sourceWarningRepository;

    @Override
    public Page<SourceWarning> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceWarningRepository.findAll(null, pageRequest);
    }
}

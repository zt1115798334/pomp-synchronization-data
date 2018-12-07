package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceUserApp;
import com.example.pompsynchronizationdata.source.repo.SourceUserAppRepository;
import com.example.pompsynchronizationdata.source.service.SourceUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 10:13
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceUserAppServiceImpl implements SourceUserAppService {

    @Autowired
    private SourceUserAppRepository sourceUserAppRepository;

    @Override
    public Page<SourceUserApp> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceUserAppRepository.findAll(null, pageRequest);

    }
}

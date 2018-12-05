package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceColumn;
import com.example.pompsynchronizationdata.source.repo.SourceColumnRepository;
import com.example.pompsynchronizationdata.source.service.SourceColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 17:52
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceColumnServiceImpl implements SourceColumnService {

    @Autowired
    private SourceColumnRepository sourceColumnRepository;

    @Override
    public Page<SourceColumn> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceColumnRepository.findAll(null,pageRequest);
    }
}

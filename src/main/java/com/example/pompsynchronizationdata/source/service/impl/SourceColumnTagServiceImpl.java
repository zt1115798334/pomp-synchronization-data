package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceColumnTag;
import com.example.pompsynchronizationdata.source.repo.SourceColumnTagRepository;
import com.example.pompsynchronizationdata.source.service.SourceColumnTagService;
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
public class SourceColumnTagServiceImpl implements SourceColumnTagService {

    @Autowired
    private SourceColumnTagRepository sourceColumnTagRepository;

    @Override
    public Page<SourceColumnTag> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceColumnTagRepository.findAll(null,pageRequest);
    }
}

package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceFilterBox;
import com.example.pompsynchronizationdata.source.repo.SourceFilterBoxRepository;
import com.example.pompsynchronizationdata.source.service.SourceFilterBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 15:33
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceFilterBoxServiceImpl implements SourceFilterBoxService {

    @Autowired
    private SourceFilterBoxRepository sourceFilterBoxRepository;

    @Override
    public Page<SourceFilterBox> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceFilterBoxRepository.findAll(null, pageRequest);

    }
}

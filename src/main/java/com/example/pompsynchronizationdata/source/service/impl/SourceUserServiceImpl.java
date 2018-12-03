package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceUser;
import com.example.pompsynchronizationdata.source.repo.SourceUserRepository;
import com.example.pompsynchronizationdata.source.service.SourceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/11/30 16:14
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceUserServiceImpl implements SourceUserService {

    @Autowired
    private SourceUserRepository sourceUserRepository;

    @Override
    public Page<SourceUser> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceUserRepository.findAll(null, pageRequest);
    }
}

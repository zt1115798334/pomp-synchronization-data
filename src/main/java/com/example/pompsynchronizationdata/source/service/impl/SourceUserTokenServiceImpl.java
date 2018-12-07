package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceUserToken;
import com.example.pompsynchronizationdata.source.repo.SourceUserTokenRepository;
import com.example.pompsynchronizationdata.source.service.SourceUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 13:41
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceUserTokenServiceImpl implements SourceUserTokenService {

    @Autowired
    private SourceUserTokenRepository sourceUserTokenRepository;

    @Override
    public Page<SourceUserToken> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceUserTokenRepository.findAll(null, pageRequest);

    }
}

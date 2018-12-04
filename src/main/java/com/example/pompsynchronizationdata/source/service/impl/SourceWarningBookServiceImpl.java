package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceWarningBook;
import com.example.pompsynchronizationdata.source.repo.SourceWarningBookRepository;
import com.example.pompsynchronizationdata.source.service.SourceWarningBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:01
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceWarningBookServiceImpl implements SourceWarningBookService {

    @Autowired
    private SourceWarningBookRepository sourceWarningBookRepository;

    @Override
    public Page<SourceWarningBook> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceWarningBookRepository.findAll(null, pageRequest);
    }
}

package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.source.entity.SourceFavorites;
import com.example.pompsynchronizationdata.source.repo.SourceFavoritesRepository;
import com.example.pompsynchronizationdata.source.service.SourceFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 15:59
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceFavoritesServiceImpl implements SourceFavoritesService {

    @Autowired
    private SourceFavoritesRepository sourceFavoritesRepository;

    @Override
    public Page<SourceFavorites> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return sourceFavoritesRepository.findAll(null, pageRequest);
    }
}

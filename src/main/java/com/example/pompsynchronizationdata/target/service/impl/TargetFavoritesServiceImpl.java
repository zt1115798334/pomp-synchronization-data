package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetFavorites;
import com.example.pompsynchronizationdata.target.repo.TargetFavoritesRepository;
import com.example.pompsynchronizationdata.target.service.TargetFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 16:05
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetFavoritesServiceImpl implements TargetFavoritesService {

    @Autowired
    private TargetFavoritesRepository targetFavoritesRepository;


    @Override
    public TargetFavorites save(TargetFavorites targetFavorites) {
        Long userId = targetFavorites.getUserId();
        String articleId = targetFavorites.getArticleId();
        Optional<TargetFavorites> favoritesOptional = targetFavoritesRepository.findByUserIdAndArticleId(userId, articleId);
        return favoritesOptional.orElseGet(() -> targetFavoritesRepository.save(targetFavorites));
    }
}

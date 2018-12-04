package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetFavorites;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 16:05
 * description:
 */
public interface TargetFavoritesRepository extends CrudRepository<TargetFavorites, Long> {
    Optional<TargetFavorites> findByUserIdAndArticleId(Long userId, String articleId);

}

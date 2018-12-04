package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceFavorites;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 15:59
 * description:
 */
public interface SourceFavoritesRepository extends CrudRepository<SourceFavorites,Long>,
        JpaSpecificationExecutor<SourceFavorites> {
}

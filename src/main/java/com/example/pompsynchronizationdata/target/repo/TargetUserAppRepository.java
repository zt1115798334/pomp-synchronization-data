package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetUserApp;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 09:56
 * description:
 */
public interface TargetUserAppRepository extends CrudRepository<TargetUserApp,Long> {

    Optional<TargetUserApp> findByUserIdAndMenuId(Long userId, Long menuId);
}

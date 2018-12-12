package com.example.pompsynchronizationdata.target.repo;


import com.example.pompsynchronizationdata.target.entity.TargetUserConfig;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/12 14:45
 * description:
 */
public interface TargetUserConfigRepository extends CrudRepository<TargetUserConfig,Long> {
    Optional<TargetUserConfig> findByUserId(Long userId);
}

package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsiteGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:20
 * description:
 */
public interface TargetAbroadWebsiteGroupRepository extends CrudRepository<TargetAbroadWebsiteGroup,Long> {

    Optional<TargetAbroadWebsiteGroup> findByUserIdAndName(Long userId, String name);
}

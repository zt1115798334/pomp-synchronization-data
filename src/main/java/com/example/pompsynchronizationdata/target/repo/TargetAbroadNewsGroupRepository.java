package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetAbroadNewsGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:19
 * description:
 */
public interface TargetAbroadNewsGroupRepository extends CrudRepository<TargetAbroadNewsGroup,Long> {

    Optional<TargetAbroadNewsGroup> findByUserId(Long userId);
}

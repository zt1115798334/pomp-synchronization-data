package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetWarningRule;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:59
 * description:
 */
public interface TargetWarningRuleRepository extends CrudRepository<TargetWarningRule,Long> {

    Optional<TargetWarningRule> findByUserIdAndWarningType(Long userId, Integer warningType);
}

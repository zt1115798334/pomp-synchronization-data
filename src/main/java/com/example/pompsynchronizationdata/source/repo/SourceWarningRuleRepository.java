package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceWarningRule;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:53
 * description:
 */
public interface SourceWarningRuleRepository extends CrudRepository<SourceWarningRule,Long>,
        JpaSpecificationExecutor<SourceWarningRule> {
}

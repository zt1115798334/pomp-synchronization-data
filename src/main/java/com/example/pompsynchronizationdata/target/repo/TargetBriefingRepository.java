package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetBriefing;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
public interface TargetBriefingRepository extends CrudRepository<TargetBriefing, Long>,
        JpaSpecificationExecutor<TargetBriefing> {
    void deleteByCreatedTimeLessThan(LocalDateTime localDateTime);
}

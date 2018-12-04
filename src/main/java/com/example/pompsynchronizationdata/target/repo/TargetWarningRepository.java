package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetWarning;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:06
 * description:
 */
public interface TargetWarningRepository extends CrudRepository<TargetWarning,Long> {
    Optional<TargetWarning> findByArticleIdAndUserId(String articleId, Long userId);
}

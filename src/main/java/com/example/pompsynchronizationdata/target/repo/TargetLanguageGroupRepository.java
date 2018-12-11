package com.example.pompsynchronizationdata.target.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.pompsynchronizationdata.target.entity.TargetLanguageGroup;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 17:24
 * description:
 */
public interface TargetLanguageGroupRepository extends CrudRepository<TargetLanguageGroup,Long> , JpaSpecificationExecutor<TargetLanguageGroup>{

	Optional<TargetLanguageGroup> findByUserId(Long userId);

}

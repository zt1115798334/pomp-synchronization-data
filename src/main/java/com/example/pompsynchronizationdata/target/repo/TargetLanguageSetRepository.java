package com.example.pompsynchronizationdata.target.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.pompsynchronizationdata.target.entity.TargetLanguageSet;
import com.example.pompsynchronizationdata.target.entity.TargetLanguages;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 17:24
 * description:
 */
public interface TargetLanguageSetRepository extends CrudRepository<TargetLanguageSet,Long> , JpaSpecificationExecutor<TargetLanguageSet>{
}

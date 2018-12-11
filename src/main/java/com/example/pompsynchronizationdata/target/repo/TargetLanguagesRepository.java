package com.example.pompsynchronizationdata.target.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.pompsynchronizationdata.target.entity.TargetLanguages;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 14:58
 * description:
 */
public interface TargetLanguagesRepository extends CrudRepository<TargetLanguages,Long>, JpaSpecificationExecutor<TargetLanguages>{
	
	TargetLanguages findNameById(Long id);
}

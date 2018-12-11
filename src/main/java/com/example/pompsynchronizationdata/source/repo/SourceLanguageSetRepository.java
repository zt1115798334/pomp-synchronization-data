package com.example.pompsynchronizationdata.source.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.pompsynchronizationdata.source.entity.SourceLanguageSet;



public interface SourceLanguageSetRepository extends CrudRepository<SourceLanguageSet, Long>, JpaSpecificationExecutor<SourceLanguageSet>{

}

package com.example.pompsynchronizationdata.source.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.pompsynchronizationdata.source.entity.SourceLanguages;



public interface SourceLanguagesRepository extends CrudRepository<SourceLanguages, Long>, JpaSpecificationExecutor<SourceLanguages>{

}

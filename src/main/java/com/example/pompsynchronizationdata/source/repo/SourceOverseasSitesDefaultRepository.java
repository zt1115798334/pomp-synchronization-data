package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesDefault;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:10
 * description:
 */
public interface SourceOverseasSitesDefaultRepository extends CrudRepository<SourceOverseasSitesDefault,Long>,
        JpaSpecificationExecutor<SourceOverseasSitesDefault> {
}

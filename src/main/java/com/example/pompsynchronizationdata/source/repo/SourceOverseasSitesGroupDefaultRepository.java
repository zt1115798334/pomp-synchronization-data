package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesGroupDefault;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:10
 * description:
 */
public interface SourceOverseasSitesGroupDefaultRepository extends CrudRepository<SourceOverseasSitesGroupDefault,Long>,
        JpaSpecificationExecutor<SourceOverseasSitesGroupDefault> {
}

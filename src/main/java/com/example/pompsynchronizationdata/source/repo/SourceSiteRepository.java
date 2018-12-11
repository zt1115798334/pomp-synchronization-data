package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceSite;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 10:36
 * description:
 */
public interface SourceSiteRepository extends CrudRepository<SourceSite,Long>,
        JpaSpecificationExecutor<SourceSite> {
}

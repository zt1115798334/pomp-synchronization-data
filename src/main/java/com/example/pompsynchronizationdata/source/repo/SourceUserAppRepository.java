package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceUserApp;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 10:13
 * description:
 */
public interface SourceUserAppRepository extends CrudRepository<SourceUserApp, Long>,
        JpaSpecificationExecutor<SourceUserApp> {
}

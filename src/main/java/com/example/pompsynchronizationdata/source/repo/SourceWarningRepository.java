package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceWarning;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:12
 * description:
 */
public interface SourceWarningRepository extends CrudRepository<SourceWarning,String>,
        JpaSpecificationExecutor<SourceWarning> {
}

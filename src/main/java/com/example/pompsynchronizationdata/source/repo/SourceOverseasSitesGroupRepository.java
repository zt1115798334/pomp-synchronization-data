package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesGroup;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:10
 * description:
 */
public interface SourceOverseasSitesGroupRepository extends CrudRepository<SourceOverseasSitesGroup,Long>,
        JpaSpecificationExecutor<SourceOverseasSitesGroup> {
}

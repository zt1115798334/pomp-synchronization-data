package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceAbroadMediaGroup;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:19
 * description:
 */
public interface SourceAbroadMediaGroupRepository extends CrudRepository<SourceAbroadMediaGroup,Long>,
        JpaSpecificationExecutor<SourceAbroadMediaGroup> {
}

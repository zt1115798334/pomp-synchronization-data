package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceEvent;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 15:39
 * description:
 */
public interface SourceEventRepository extends CrudRepository<SourceEvent, Long>,
        JpaSpecificationExecutor<SourceEvent> {
}

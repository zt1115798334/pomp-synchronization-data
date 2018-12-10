package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceMessage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:04
 * description:
 */
public interface SourceMessageRepository extends CrudRepository<SourceMessage,Long>,
        JpaSpecificationExecutor<SourceMessage> {
}

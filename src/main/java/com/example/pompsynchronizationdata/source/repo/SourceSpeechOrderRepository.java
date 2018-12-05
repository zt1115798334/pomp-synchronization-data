package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceSpeechOrder;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:30
 * description:
 */
public interface SourceSpeechOrderRepository extends CrudRepository<SourceSpeechOrder,Long>,
        JpaSpecificationExecutor<SourceSpeechOrder> {
}

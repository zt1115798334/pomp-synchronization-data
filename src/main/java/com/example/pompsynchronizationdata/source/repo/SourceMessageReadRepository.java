package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceMessageRead;
import com.example.pompsynchronizationdata.source.entity.SourceMessageReadKey;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:04
 * description:
 */
public interface SourceMessageReadRepository extends CrudRepository<SourceMessageRead, SourceMessageReadKey>,
        JpaSpecificationExecutor<SourceMessageRead> {
}

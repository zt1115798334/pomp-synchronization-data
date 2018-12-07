package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceFilterBox;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 15:33
 * description:
 */
public interface SourceFilterBoxRepository extends CrudRepository<SourceFilterBox, Long>,
        JpaSpecificationExecutor<SourceFilterBox> {
}

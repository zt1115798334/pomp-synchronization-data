package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceColumnTag;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 17:52
 * description:
 */
public interface SourceColumnTagRepository extends CrudRepository<SourceColumnTag,Long>,
        JpaSpecificationExecutor<SourceColumnTag> {
}

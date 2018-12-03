package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/11/30 16:14
 * description:
 */
public interface SourceUserRepository extends CrudRepository<SourceUser, Long>,
        JpaSpecificationExecutor<SourceUser> {
}

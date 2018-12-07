package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceUserToken;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 13:41
 * description:
 */
public interface SourceUserTokenRepository extends CrudRepository<SourceUserToken,Long>,
        JpaSpecificationExecutor<SourceUserToken> {
}

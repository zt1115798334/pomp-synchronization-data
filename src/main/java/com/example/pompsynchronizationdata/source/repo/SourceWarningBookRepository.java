package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceWarningBook;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:01
 * description:
 */
public interface SourceWarningBookRepository extends CrudRepository<SourceWarningBook,Long>,
        JpaSpecificationExecutor<SourceWarningBook> {
}

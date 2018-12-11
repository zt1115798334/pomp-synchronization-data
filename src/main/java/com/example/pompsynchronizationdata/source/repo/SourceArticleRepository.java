package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceArticle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 09:50
 * description:
 */
public interface SourceArticleRepository extends CrudRepository<SourceArticle,String>,
        JpaSpecificationExecutor<SourceArticle> {
}

package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceBriefingArticle;
import com.example.pompsynchronizationdata.source.entity.SourceBriefingArticleKey;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:19
 * description:
 */
public interface SourceBriefingArticleRepository extends CrudRepository<SourceBriefingArticle, SourceBriefingArticleKey>,
        JpaSpecificationExecutor<SourceBriefingArticle> {
}

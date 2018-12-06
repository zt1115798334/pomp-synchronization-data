package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceSpeechArticle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 11:11
 * description:
 */
public interface SourceSpeechArticleRepository extends CrudRepository<SourceSpeechArticle,Long>,
        JpaSpecificationExecutor<SourceSpeechArticle> {
}

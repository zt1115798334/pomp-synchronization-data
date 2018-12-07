package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceCommentAnalysis;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 16:24
 * description:
 */
public interface SourceCommentAnalysisRepository extends CrudRepository<SourceCommentAnalysis, Long>,
        JpaSpecificationExecutor<SourceCommentAnalysis> {
}

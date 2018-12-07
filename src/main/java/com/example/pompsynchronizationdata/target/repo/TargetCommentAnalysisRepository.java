package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetCommentAnalysis;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 16:15
 * description:
 */
public interface TargetCommentAnalysisRepository extends CrudRepository<TargetCommentAnalysis,Long> {

    Optional<TargetCommentAnalysis> findByUrlMd5(String urlMd5);
}

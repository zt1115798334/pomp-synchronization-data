package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetBriefingArticle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
public interface TargetBriefingArticleRepository extends CrudRepository<TargetBriefingArticle, Long> {

    Optional<TargetBriefingArticle> findByBriefingIdAndTemplateNumberAndArticleId(Long briefingId, Integer templateNumber, String articleId);
}

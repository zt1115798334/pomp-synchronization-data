package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetBriefingArticle;
import com.example.pompsynchronizationdata.target.repo.TargetBriefingArticleRepository;
import com.example.pompsynchronizationdata.target.service.TargetBriefingArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetBriefingArticleServiceImpl implements TargetBriefingArticleService {

    @Autowired
    private TargetBriefingArticleRepository targetBriefingArticleRepository;

    @Override
    public TargetBriefingArticle save(TargetBriefingArticle targetBriefingArticle) {
        Optional<TargetBriefingArticle> briefingArticleOptional = targetBriefingArticleRepository.findByBriefingIdAndTemplateNumberAndArticleId(targetBriefingArticle.getBriefingId(), targetBriefingArticle.getTemplateNumber(), targetBriefingArticle.getArticleId());
        return briefingArticleOptional.orElseGet(() -> targetBriefingArticleRepository.save(targetBriefingArticle));
    }

}

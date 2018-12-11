package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetArticle;
import com.example.pompsynchronizationdata.target.repo.TargetArticleRepository;
import com.example.pompsynchronizationdata.target.service.TargetArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 09:46
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetArticleServiceImpl implements TargetArticleService {

    @Autowired
    private TargetArticleRepository targetArticleRepository;

    @Override
    public TargetArticle save(TargetArticle targetArticle) {
        Optional<TargetArticle> targetArticleOptional = targetArticleRepository.findById(targetArticle.getId());
        return targetArticleOptional.orElseGet(() -> targetArticleRepository.save(targetArticle));
    }
}

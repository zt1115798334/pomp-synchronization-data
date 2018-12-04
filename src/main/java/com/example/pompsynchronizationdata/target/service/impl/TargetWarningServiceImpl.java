package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetWarning;
import com.example.pompsynchronizationdata.target.repo.TargetWarningRepository;
import com.example.pompsynchronizationdata.target.service.TargetWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:06
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetWarningServiceImpl implements TargetWarningService {

    @Autowired
    private TargetWarningRepository targetWarningRepository;

    @Override
    public TargetWarning save(TargetWarning targetWarning) {
        try {
            String articleId = targetWarning.getArticleId();
            Long userId = targetWarning.getUserId();
            Optional<TargetWarning> targetWarningOptional = targetWarningRepository.findByArticleIdAndUserId(articleId, userId);
            return targetWarningOptional.orElseGet(() -> targetWarningRepository.save(targetWarning));
        } catch (Exception e) {
            System.out.println("报错的信息id为" + targetWarning.getArticleId() + "用户id为:" + targetWarning.getUserId());
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Optional<TargetWarning> findByArticleIdAndUserId(String articleId, Long userId) {
        return targetWarningRepository.findByArticleIdAndUserId(articleId, userId);
    }
}

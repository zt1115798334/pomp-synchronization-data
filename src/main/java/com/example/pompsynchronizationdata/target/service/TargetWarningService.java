package com.example.pompsynchronizationdata.target.service;


import com.example.pompsynchronizationdata.base.service.BaseService;
import com.example.pompsynchronizationdata.target.entity.TargetWarning;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:06
 * description:
 */
public interface TargetWarningService extends BaseService<TargetWarning> {

    Optional<TargetWarning> findByArticleIdAndUserId(String articleId, Long userId);

}

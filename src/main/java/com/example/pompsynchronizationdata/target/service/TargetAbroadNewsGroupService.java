package com.example.pompsynchronizationdata.target.service;


import com.example.pompsynchronizationdata.base.service.BaseService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadNewsGroup;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:19
 * description:
 */
public interface TargetAbroadNewsGroupService extends BaseService<TargetAbroadNewsGroup> {

    Optional<TargetAbroadNewsGroup> findByUserId(Long userId);
}

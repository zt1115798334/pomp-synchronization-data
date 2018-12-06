package com.example.pompsynchronizationdata.target.service;


import com.example.pompsynchronizationdata.base.service.BaseService;
import com.example.pompsynchronizationdata.target.entity.TargetBriefingSetting;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
public interface TargetBriefingSettingService extends BaseService<TargetBriefingSetting> {

    List<TargetBriefingSetting> findByUserId(Long userId);
}

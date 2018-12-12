package com.example.pompsynchronizationdata.target.service;


import com.example.pompsynchronizationdata.base.service.BaseService;
import com.example.pompsynchronizationdata.target.entity.TargetUserConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/12 14:45
 * description:
 */
public interface TargetUserConfigService extends BaseService<TargetUserConfig> {

    void save(Long userId);

}

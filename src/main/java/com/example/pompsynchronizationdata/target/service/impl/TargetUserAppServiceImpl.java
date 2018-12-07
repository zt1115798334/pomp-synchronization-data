package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetUserApp;
import com.example.pompsynchronizationdata.target.repo.TargetUserAppRepository;
import com.example.pompsynchronizationdata.target.service.TargetUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 09:56
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetUserAppServiceImpl implements TargetUserAppService {

    @Autowired
    private TargetUserAppRepository targetUserAppRepository;

    @Override
    public TargetUserApp save(TargetUserApp targetUserApp) {
        Long userId = targetUserApp.getUserId();
        Long menuId = targetUserApp.getMenuId();

        Optional<TargetUserApp> targetUserAppOptional = targetUserAppRepository.findByUserIdAndMenuId(userId, menuId);
        return targetUserAppOptional.orElseGet(() -> targetUserAppRepository.save(targetUserApp));
    }
}

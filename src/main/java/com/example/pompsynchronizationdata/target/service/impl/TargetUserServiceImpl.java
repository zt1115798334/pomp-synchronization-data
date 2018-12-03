package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetUser;
import com.example.pompsynchronizationdata.target.repo.TargetUserRepository;
import com.example.pompsynchronizationdata.target.service.TargetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/11/30 16:11
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetUserServiceImpl implements TargetUserService {

    @Autowired
    private TargetUserRepository targetUserRepository;

    @Override
    public TargetUser save(TargetUser targetUser) {
        Optional<TargetUser> targetUserOptional = targetUserRepository.findByPhone(targetUser.getPhone());
        return targetUserOptional.orElseGet(() -> targetUserRepository.save(targetUser));
    }
}

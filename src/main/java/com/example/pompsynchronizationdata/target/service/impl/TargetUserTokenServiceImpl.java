package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetUserToken;
import com.example.pompsynchronizationdata.target.repo.TargetUserTokenRepository;
import com.example.pompsynchronizationdata.target.service.TargetUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 13:46
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetUserTokenServiceImpl implements TargetUserTokenService {

    @Autowired
    private TargetUserTokenRepository targetUserTokenRepository;

    @Override
    public TargetUserToken save(TargetUserToken targetUserToken) {
        Optional<TargetUserToken> userTokenOptional = targetUserTokenRepository.findByUserIdAndRegistrationId(targetUserToken.getUserId(), targetUserToken.getRegistrationId());
        return userTokenOptional.orElseGet(() -> targetUserTokenRepository.save(targetUserToken));
    }
}

package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetUserToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 13:46
 * description:
 */
public interface TargetUserTokenRepository extends CrudRepository<TargetUserToken,Long> {

    Optional<TargetUserToken> findByUserIdAndRegistrationId(Long userId, String registrationId);
}

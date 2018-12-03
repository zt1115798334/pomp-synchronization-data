package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/11/30 16:11
 * description:
 */
public interface TargetUserRepository extends CrudRepository<TargetUser,Long> {
    Optional<TargetUser> findByPhone(String phone);
}

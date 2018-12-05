package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetEvent;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 15:55
 * description:
 */
public interface TargetEventRepository extends CrudRepository<TargetEvent,Long> {
}

package com.example.pompsynchronizationdata.target.repo;

import com.example.pompsynchronizationdata.target.entity.TargetBriefingSetting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
public interface TargetBriefingSettingRepository extends CrudRepository<TargetBriefingSetting,Long> {

    List<TargetBriefingSetting> findByuserId(Long userId);
}

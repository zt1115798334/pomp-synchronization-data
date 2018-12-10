package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceAbroadMediaSetting;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:19
 * description:
 */
public interface SourceAbroadMediaSettingRepository extends CrudRepository<SourceAbroadMediaSetting,Long> ,
        JpaSpecificationExecutor<SourceAbroadMediaSetting> {
}

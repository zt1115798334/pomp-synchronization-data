package com.example.pompsynchronizationdata.source.repo;

import com.example.pompsynchronizationdata.source.entity.SourceAbroadSetting;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:32
 * description:
 */
public interface SourceAbroadSettingRepository extends CrudRepository<SourceAbroadSetting,Long>,
        JpaSpecificationExecutor<SourceAbroadSetting> {
}

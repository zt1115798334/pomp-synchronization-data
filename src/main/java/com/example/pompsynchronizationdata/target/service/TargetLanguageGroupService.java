package com.example.pompsynchronizationdata.target.service;

import java.util.Optional;

import com.example.pompsynchronizationdata.base.service.BaseService;
import com.example.pompsynchronizationdata.target.entity.TargetLanguageGroup;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 17:24
 * description:
 */
public interface TargetLanguageGroupService extends BaseService<TargetLanguageGroup> {

	Optional<TargetLanguageGroup> findByUserId(Long sourceLanguageSetUserId);

}

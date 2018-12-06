package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.target.entity.TargetBriefing;
import com.example.pompsynchronizationdata.target.repo.TargetBriefingRepository;
import com.example.pompsynchronizationdata.target.service.TargetBriefingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetBriefingServiceImpl implements TargetBriefingService {

    @Autowired
    private TargetBriefingRepository targetBriefingRepository;

    @Override
    public TargetBriefing save(TargetBriefing targetBriefing) {
        return targetBriefingRepository.save(targetBriefing);
    }

    @Override
    public Page<TargetBriefing> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        return targetBriefingRepository.findAll(null,pageRequest);

    }

    @Override
    public Optional<TargetBriefing> findById(Long id) {
        return targetBriefingRepository.findById(id);
    }

    @Override
    public void deleteByLT(LocalDateTime localDateTime) {
        targetBriefingRepository.deleteByCreatedTimeLessThan(localDateTime);
    }
}

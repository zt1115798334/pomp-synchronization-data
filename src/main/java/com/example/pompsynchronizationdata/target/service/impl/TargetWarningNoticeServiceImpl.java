package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetWarningNotice;
import com.example.pompsynchronizationdata.target.repo.TargetWarningNoticeRepository;
import com.example.pompsynchronizationdata.target.service.TargetWarningNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:07
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetWarningNoticeServiceImpl implements TargetWarningNoticeService {

    @Autowired
    private TargetWarningNoticeRepository targetWarningNoticeRepository;

    @Override
    public TargetWarningNotice save(TargetWarningNotice targetWarningNotice) {
        return targetWarningNoticeRepository.save(targetWarningNotice);
    }
}

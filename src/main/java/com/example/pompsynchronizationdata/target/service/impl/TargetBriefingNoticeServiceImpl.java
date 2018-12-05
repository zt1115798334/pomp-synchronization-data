package com.example.pompsynchronizationdata.target.service.impl;

import com.example.pompsynchronizationdata.target.entity.TargetBriefingNotice;
import com.example.pompsynchronizationdata.target.repo.TargetBriefingNoticeRepository;
import com.example.pompsynchronizationdata.target.service.TargetBriefingNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class TargetBriefingNoticeServiceImpl implements TargetBriefingNoticeService {

    @Autowired
    private TargetBriefingNoticeRepository targetBriefingNoticeRepository;

    @Override
    public TargetBriefingNotice save(TargetBriefingNotice targetBriefingNotice) {
        return targetBriefingNoticeRepository.save(targetBriefingNotice);
    }
}

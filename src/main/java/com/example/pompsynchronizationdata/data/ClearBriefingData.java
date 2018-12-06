package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.target.service.TargetBriefingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 14:50
 * description:
 */
@Component
public class ClearBriefingData {

    @Autowired
    private TargetBriefingService targetBriefingService;

    public void handle() {
        LocalDateTime localDateTime = DateUtils.currentDateTimeAddMonth(-4);
        targetBriefingService.deleteByLT(localDateTime);
    }
}

package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceBriefing;
import com.example.pompsynchronizationdata.source.service.SourceBriefingService;
import com.example.pompsynchronizationdata.target.entity.TargetBriefing;
import com.example.pompsynchronizationdata.target.service.TargetBriefingService;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 10:07
 * description:
 */
@Component
public class BriefingCopy extends PageHandler<SourceBriefing> {

    @Autowired
    SourceBriefingService sourceBriefingService;

    @Autowired
    TargetBriefingService targetBriefingService;

    @Override
    protected int handleDataOfPerPage(List<SourceBriefing> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceBriefing sourceBriefing = list.get(i);
            Long sourceBriefingId = sourceBriefing.getId();
            String sourceBriefingUserId = sourceBriefing.getUserId();
            Integer sourceBriefingChartFenbu = sourceBriefing.getChartFenbu();
            Integer sourceBriefingChartShuxing = sourceBriefing.getChartShuxing();
            Integer sourceBriefingChartFumian = sourceBriefing.getChartFumian();
            Integer sourceBriefingChartZhengmian = sourceBriefing.getChartZhengmian();
            String sourceBriefingCheckedTable = sourceBriefing.getCheckedTable();
            String sourceBriefingCheckedList = sourceBriefing.getCheckedList();
            String sourceBriefingContent = sourceBriefing.getContent();
            LocalDateTime sourceBriefingTime = sourceBriefing.getTime();
            Long sourceBriefingType = sourceBriefing.getType();
            Integer sourceBriefingIsDelete = sourceBriefing.getIsDelete();
            String sourceBriefingTemplateType = sourceBriefing.getTemplateType();
            LocalDateTime sourceBriefingStartDateTime = sourceBriefing.getStartDateTime();
            LocalDateTime sourceBriefingEndDateTime = sourceBriefing.getEndDateTime();


            if (sourceBriefingTime != null && sourceBriefingUserId != null) {

                Long id = sourceBriefingId;
                Long userId = Long.valueOf(sourceBriefingUserId);
                LocalDateTime thisTimeYesterday = DateUtils.dateTimeAddDay(sourceBriefingTime, -1);
                LocalDateTime createdTime = sourceBriefingTime;
                LocalDate briefingDate = thisTimeYesterday.toLocalDate();

                LocalDateTime briefingStartTime = null;
                LocalDateTime briefingEndTime = null;

                String briefingType = null;
                if (sourceBriefingType == 0) {//日报
                    briefingType = SysConst.BriefingType.DAY.getType();
                    //获取日报时间间隔
                    if (sourceBriefingStartDateTime != null && sourceBriefingEndDateTime != null) {
                        briefingStartTime = sourceBriefingStartDateTime;
                        briefingEndTime = sourceBriefingEndDateTime;
                    } else {
                        briefingStartTime = DateUtils.dateTimeToFirstTime(thisTimeYesterday);
                        briefingEndTime = DateUtils.dateTimeToLastTime(thisTimeYesterday);
                    }
                }
                if (sourceBriefingType == 1) {//周报
                    briefingType = SysConst.BriefingType.WEEK.getType();
                    //获取周报时间间隔
                    if (sourceBriefingStartDateTime != null && sourceBriefingEndDateTime != null) {
                        briefingStartTime = sourceBriefingStartDateTime;
                        briefingEndTime = sourceBriefingEndDateTime;
                    } else {
                        briefingStartTime = DateUtils.dateTimeToFirstTime(DateUtils.dateTimeAddDay(thisTimeYesterday, -7));
                        briefingEndTime = DateUtils.dateTimeToLastTime(thisTimeYesterday);
                    }
                }
                if (sourceBriefingType == 2) {//月报
                    briefingType = SysConst.BriefingType.MONTH.getType();
                    //获取月报时间间隔
                    if (sourceBriefingStartDateTime != null && sourceBriefingEndDateTime != null) {
                        briefingStartTime = sourceBriefingStartDateTime;
                        briefingEndTime = sourceBriefingEndDateTime;
                    } else {
                        briefingStartTime = DateUtils.dateTimeToMonthFirstDay(thisTimeYesterday);
                        briefingEndTime = DateUtils.dateTimeToMonthLastDay(thisTimeYesterday);
                    }
                }
                Integer templateType = null;

                if (Objects.equal(sourceBriefingTemplateType, "1")) {   //通用版
                    templateType = SysConst.TemplateType.CURRENCY_EDITION.getCode();
                }
                if (Objects.equal(sourceBriefingTemplateType, "2")) {   //媒体版
                    templateType = SysConst.TemplateType.MEDIA_EDITION.getCode();
                }

                Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
                if (sourceBriefingIsDelete == 0) {//no delete
                    deleteState = SysConst.DeleteState.UN_DELETED.getCode();
                }
                if (sourceBriefingIsDelete == 1) {//delete
                    deleteState = SysConst.DeleteState.DELETE.getCode();
                }
                if (templateType != null && briefingType != null && briefingDate != null) {
                    TargetBriefing targetBriefing = new TargetBriefing();
                    targetBriefing.setId(id);
                    targetBriefing.setUserId(userId);
                    targetBriefing.setBriefingStartTime(briefingStartTime);
                    targetBriefing.setBriefingEndTime(briefingEndTime);
                    targetBriefing.setBriefingType(briefingType);
                    targetBriefing.setTemplateType(templateType);
                    targetBriefing.setBriefingDate(briefingDate);
                    targetBriefing.setCreatedTime(createdTime);
                    targetBriefing.setDeleteState(deleteState);

                    targetBriefingService.save(targetBriefing);
                }

            }

        }
        return size;
    }

    @Override
    protected Page<SourceBriefing> getPageList(int pageNumber) {
        return sourceBriefingService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

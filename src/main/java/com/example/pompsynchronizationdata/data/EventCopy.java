package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceEvent;
import com.example.pompsynchronizationdata.source.service.SourceEventService;
import com.example.pompsynchronizationdata.target.entity.TargetEvent;
import com.example.pompsynchronizationdata.target.service.TargetEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/5 16:00
 * description:
 */
@Component
public class EventCopy extends PageHandler<SourceEvent> {

    @Autowired
    SourceEventService sourceEventService;

    @Autowired
    TargetEventService targetEventService;

    @Override
    protected int handleDataOfPerPage(List<SourceEvent> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceEvent sourceEvent = list.get(i);

            Long sourceEventId = sourceEvent.getId();
            Integer sourceEventUserId = sourceEvent.getUserId();
            String sourceEventTitle = sourceEvent.getTitle();
            String sourceEventWord = sourceEvent.getWord();
            String sourceEventYuqingWord = sourceEvent.getYuqingWord();
            String sourceEventExcludeWord = sourceEvent.getExcludeWord();
            LocalDateTime sourceEventStartTime = sourceEvent.getStartTime();
            LocalDateTime sourceEventEndTime = sourceEvent.getEndTime();
            LocalDateTime sourceEventTime = sourceEvent.getTime();
            Long sourceEventEventId = sourceEvent.getEventId();
            Integer sourceEventIsTop = sourceEvent.getIsTop();
            LocalDateTime sourceEventTopTime = sourceEvent.getTopTime();
            Integer sourceEventIsDelete = sourceEvent.getIsDelete();
            Integer sourceEventAppShowAs = sourceEvent.getAppShowAs();
            Integer sourceEventAppTopShowAs = sourceEvent.getAppTopShowAs();


            Long id;
            Long userId;
            String eventTitle;
            LocalDateTime eventStartTime;
            LocalDateTime eventEndTime;
            String relatedWords;
            String opinionWords;
            String exclusionWords;
            LocalDateTime createdTime;
            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            Integer showState = SysConst.ShowState.DISPLAY.getCode();
            Integer topState = SysConst.TopState.UN_TOP.getCode();
            LocalDateTime topTime = null;
            Integer appShowState = SysConst.ShowState.DISPLAY.getCode();
            Integer appTopState = SysConst.TopState.UN_TOP.getCode();

            LocalDateTime appTopTime = null;


            id = sourceEventId;
            userId = Long.valueOf(sourceEventUserId);
            eventTitle = sourceEventTitle;
            eventStartTime = sourceEventStartTime;
            eventEndTime = sourceEventEndTime;
            relatedWords = sourceEventWord;
            opinionWords = sourceEventYuqingWord;
            exclusionWords = sourceEventExcludeWord;
            createdTime = sourceEventTime;
            if (sourceEventIsDelete != null) {
                if (sourceEventIsDelete == 1) { //delete
                    deleteState = SysConst.DeleteState.DELETE.getCode();
                }
                if (sourceEventIsDelete == 0) { //no delete
                    deleteState = SysConst.DeleteState.UN_DELETED.getCode();
                }
            }
            if (sourceEventIsTop != null) {
                if (sourceEventIsTop == 1) { //top
                    topState = SysConst.TopState.TOP.getCode();
                    topTime = sourceEventTopTime;
                }
                if (sourceEventIsTop == 0) {//no top
                    topState = SysConst.TopState.UN_TOP.getCode();
                }
            }
            if (sourceEventAppShowAs == null) {
                if (sourceEventAppShowAs == 1) {//show
                    appShowState = SysConst.ShowState.DISPLAY.getCode();
                }
                if (sourceEventAppShowAs == 0) {// no show
                    appShowState = SysConst.ShowState.HIDE.getCode();
                }
            }
            if (sourceEventAppTopShowAs == null) {
                if (sourceEventAppTopShowAs == 0) {
                    //no top
                    appTopState = SysConst.TopState.UN_TOP.getCode();
                }
                if (sourceEventAppTopShowAs == 1) {
                    //top
                    appTopState = SysConst.TopState.TOP.getCode();
                    appTopTime = DateUtils.currentDateTime();
                }
            }


            TargetEvent targetEvent = new TargetEvent();
            targetEvent.setId(id);
            targetEvent.setUserId(userId);
            targetEvent.setEventTitle(eventTitle);
            targetEvent.setEventStartTime(eventStartTime);
            targetEvent.setEventEndTime(eventEndTime);
            targetEvent.setRelatedWords(relatedWords);
            targetEvent.setOpinionWords(opinionWords);
            targetEvent.setExclusionWords(exclusionWords);
            targetEvent.setCreatedTime(createdTime);
            targetEvent.setDeleteState(deleteState);
            targetEvent.setShowState(showState);
            targetEvent.setTopState(topState);
            targetEvent.setTopTime(topTime);
            targetEvent.setAppShowState(appShowState);
            targetEvent.setAppTopState(appTopState);
            targetEvent.setAppTopTime(appTopTime);

            targetEventService.save(targetEvent);
        }
        return size;
    }

    @Override
    protected Page<SourceEvent> getPageList(int pageNumber) {
        return sourceEventService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

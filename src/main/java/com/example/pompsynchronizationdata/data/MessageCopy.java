package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceMessage;
import com.example.pompsynchronizationdata.source.service.SourceMessageService;
import com.example.pompsynchronizationdata.target.entity.TargetMessage;
import com.example.pompsynchronizationdata.target.service.TargetMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:12
 * description:
 */
@Component
public class MessageCopy extends PageHandler<SourceMessage> {

    @Autowired
    private SourceMessageService sourceMessageService;

    @Autowired
    private TargetMessageService targetMessageService;

    @Override
    protected int handleDataOfPerPage(List<SourceMessage> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceMessage sourceMessage = list.get(i);
            Long sourceMessageId = sourceMessage.getId();
            Integer sourceMessageUserLevel = sourceMessage.getUserLevel();
            Integer sourceMessageUserId = sourceMessage.getUserId();
            String sourceMessageTitle = sourceMessage.getTitle();
            String sourceMessageContent = sourceMessage.getContent();
            Integer sourceMessageType = sourceMessage.getType();
            Integer sourceMessageIsdelete = sourceMessage.getIsdelete();
            LocalDateTime sourceMessageTime = sourceMessage.getTime();
            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            if (sourceMessageIsdelete == 0) { // no delete
                deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            }
            if (sourceMessageIsdelete == 1) { //delete
                deleteState = SysConst.DeleteState.DELETE.getCode();
            }
            if (sourceMessageUserId == null) {
                sourceMessageUserId = 1;
            }
            TargetMessage targetMessage = new TargetMessage();
            targetMessage.setId(sourceMessageId);
            targetMessage.setUserLevel(sourceMessageUserLevel);
            targetMessage.setCreatedUserId(Long.valueOf(sourceMessageUserId));
            targetMessage.setTitle(sourceMessageTitle);
            targetMessage.setContent(sourceMessageContent);
            targetMessage.setMessageType(sourceMessageType);
            targetMessage.setDeleteState(deleteState);
            targetMessage.setCreatedTime(sourceMessageTime);
            targetMessageService.save(targetMessage);

        }
        return size;
    }

    @Override
    protected Page<SourceMessage> getPageList(int pageNumber) {
        return sourceMessageService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

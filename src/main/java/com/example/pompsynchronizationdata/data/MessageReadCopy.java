package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceMessageRead;
import com.example.pompsynchronizationdata.source.service.SourceMessageReadService;
import com.example.pompsynchronizationdata.target.entity.TargetMessageRead;
import com.example.pompsynchronizationdata.target.service.TargetMessageReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:21
 * description:
 */
@Component
public class MessageReadCopy extends PageHandler<SourceMessageRead> {

    @Autowired
    private SourceMessageReadService sourceMessageReadService;

    @Autowired
    private TargetMessageReadService targetMessageReadService;
    @Override
    protected int handleDataOfPerPage(List<SourceMessageRead> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceMessageRead sourceMessageRead = list.get(i);
            Long sourceMessageReadMessageId = sourceMessageRead.getId().getMessageId();
            Integer sourceMessageReadUserId = sourceMessageRead.getId().getUserId();
            LocalDateTime sourceMessageReadTime = sourceMessageRead.getTime();

            TargetMessageRead targetMessageRead = new TargetMessageRead();

            targetMessageRead.setMessageId(sourceMessageReadMessageId);
            targetMessageRead.setUserId(Long.valueOf(sourceMessageReadUserId));
            targetMessageRead.setCreatedTime(sourceMessageReadTime);
            targetMessageReadService.save(targetMessageRead);
        }
        return size;
    }

    @Override
    protected Page<SourceMessageRead> getPageList(int pageNumber) {
        return sourceMessageReadService.findPageByEntity(pageNumber,DEFAULT_BATCH_SIZE);
    }
}

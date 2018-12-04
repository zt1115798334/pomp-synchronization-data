package com.example.pompsynchronizationdata.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceWarningBook;
import com.example.pompsynchronizationdata.source.service.SourceWarningBookService;
import com.example.pompsynchronizationdata.target.entity.TargetWarningNotice;
import com.example.pompsynchronizationdata.target.service.TargetWarningNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/3 15:11
 * description:
 */
@Component
public class WarningNoticeCopy extends PageHandler<SourceWarningBook> {

    @Autowired
    private SourceWarningBookService sourceWarningBookService;

    @Autowired
    private TargetWarningNoticeService targetWarningNoticeService;


    @Override
    protected int handleDataOfPerPage(List<SourceWarningBook> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 20, '=');
        for (int i = 0; i < size; i++) {
            SourceWarningBook sourceWarningBook = list.get(i);
            Long sourceWarningBookId = sourceWarningBook.getId();
            Long sourceWarningBookUserId = sourceWarningBook.getUserId();
            String sourceWarningBookName = sourceWarningBook.getName();
            Integer sourceWarningBookStatus = sourceWarningBook.getStatus();
            Integer sourceWarningBookType = sourceWarningBook.getType();
            String sourceWarningBookValue = sourceWarningBook.getValue();
            LocalDateTime sourceWarningBookTime = sourceWarningBook.getTime();
            JSONObject sourceWarningBookValueJSON = JSON.parseObject(sourceWarningBookValue);


            TargetWarningNotice targetWarningNotice = new TargetWarningNotice();
            targetWarningNotice.setId(sourceWarningBookId);
            targetWarningNotice.setUserId(sourceWarningBookUserId);
            targetWarningNotice.setNoticeUsername(sourceWarningBookName);
            if (sourceWarningBookValueJSON.containsKey("email")) {
                targetWarningNotice.setEmail(sourceWarningBookValueJSON.getString("email"));
            }
            if (sourceWarningBookValueJSON.containsKey("phone")) {
                targetWarningNotice.setPhone(sourceWarningBookValueJSON.getString("phone"));
            }
            targetWarningNoticeService.save(targetWarningNotice);
            cpb.show(i);
        }
        return size;
    }

    @Override
    protected Page<SourceWarningBook> getPageList(int pageNumber) {
        return sourceWarningBookService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

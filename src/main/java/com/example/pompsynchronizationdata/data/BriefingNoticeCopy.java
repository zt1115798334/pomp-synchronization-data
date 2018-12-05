package com.example.pompsynchronizationdata.data;

import com.alibaba.fastjson.JSONObject;
import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceSpeechOrder;
import com.example.pompsynchronizationdata.source.service.SourceSpeechOrderService;
import com.example.pompsynchronizationdata.target.entity.TargetBriefingNotice;
import com.example.pompsynchronizationdata.target.service.TargetBriefingNoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/5 17:02
 * description:
 */
@Component
public class BriefingNoticeCopy extends PageHandler<SourceSpeechOrder> {

    @Autowired
    private SourceSpeechOrderService sourceSpeechOrderService;

    @Autowired
    private TargetBriefingNoticeService targetBriefingNoticeService;

    @Override
    protected int handleDataOfPerPage(List<SourceSpeechOrder> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceSpeechOrder sourceSpeechOrder = list.get(i);
            Long sourceSpeechOrderId = sourceSpeechOrder.getId();
            Long sourceSpeechOrderUserId = sourceSpeechOrder.getUserId();
            String orderContent = sourceSpeechOrder.getOrderContent();

            if (StringUtils.isNotEmpty(orderContent)) {
                JSONObject orderContentJSON = JSONObject.parseObject(orderContent);
                if (orderContentJSON.containsKey("email")) {
                    String emailStr = orderContentJSON.getString("email");
                    Arrays.stream(emailStr.split(",")).forEach(str -> {
                        TargetBriefingNotice targetBriefingNotice = new TargetBriefingNotice();
                        targetBriefingNotice.setUserId(sourceSpeechOrderUserId);
                        targetBriefingNotice.setEmail(str);
                        targetBriefingNoticeService.save(targetBriefingNotice);
                    });

                }
            }
        }
        return size;
    }

    @Override
    protected Page<SourceSpeechOrder> getPageList(int pageNumber) {
        return sourceSpeechOrderService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

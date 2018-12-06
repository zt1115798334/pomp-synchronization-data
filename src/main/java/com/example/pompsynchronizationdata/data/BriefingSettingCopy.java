package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceBriefingSetting;
import com.example.pompsynchronizationdata.source.service.SourceBriefingSettingService;
import com.example.pompsynchronizationdata.target.entity.TargetBriefingSetting;
import com.example.pompsynchronizationdata.target.service.TargetBriefingSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/5 17:50
 * description:
 */
@Component
public class BriefingSettingCopy extends PageHandler<SourceBriefingSetting> {

    @Autowired
    SourceBriefingSettingService sourceBriefingSettingService;

    @Autowired
    TargetBriefingSettingService targetBriefingSettingService;

    @Override
    protected int handleDataOfPerPage(List<SourceBriefingSetting> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceBriefingSetting sourceBriefingSetting = list.get(i);
            Long sourceBriefingSettingUserId = sourceBriefingSetting.getUserId();
            LocalDateTime sourceBriefingSettingTime = sourceBriefingSetting.getTime();
            String sourceBriefingSettingGenerationTime = sourceBriefingSetting.getGenerationTime();
            String sourceBriefingSettingGenerationSyncTime = sourceBriefingSetting.getGenerationSyncTime();
            String sourceBriefingSettingBriefingType = sourceBriefingSetting.getBriefingType();
            String briefingSettingTemplateType = sourceBriefingSetting.getTemplateType();
            String sourceBriefingSettingSwitchState = sourceBriefingSetting.getSwitchState();
            Integer sourceBriefingSettingIsCustom = sourceBriefingSetting.getIsCustom();


            Long userId = sourceBriefingSettingUserId;
            LocalDateTime createdTime = sourceBriefingSettingTime;
            Integer generationTime = Integer.valueOf(sourceBriefingSettingGenerationTime);
            Integer generationSyncTime = Integer.valueOf(sourceBriefingSettingGenerationSyncTime);

            String briefingType = null;
            switch (sourceBriefingSettingBriefingType) {
                case "day":
                    briefingType = SysConst.BriefingType.DAY.getType();
                    break;
                case "week":
                    briefingType = SysConst.BriefingType.WEEK.getType();
                    break;
                case "month":
                    briefingType = SysConst.BriefingType.MONTH.getType();
                    break;
            }

            Integer templateType = null;

            if (briefingSettingTemplateType.equals("1")) {//通用版
                templateType = SysConst.TemplateType.CURRENCY_EDITION.getCode();
            }
            if (briefingSettingTemplateType.equals("2")) {//媒体版
                templateType = SysConst.TemplateType.MEDIA_EDITION.getCode();
            }

            Integer enabledState = null;
            if (sourceBriefingSettingSwitchState.equals("on")) { //开
                enabledState = SysConst.EnabledState.ON.getCode();
            }
            if (sourceBriefingSettingSwitchState.equals("off")) { //关
                enabledState = SysConst.EnabledState.OFF.getCode();

            }
            Integer customState = null;
            if (sourceBriefingSettingIsCustom == 0) {   //默认
                customState = SysConst.BriefingCustom.DEFAULT.getCode();
            }
            if (sourceBriefingSettingIsCustom == 1) {//自定义
                customState = SysConst.BriefingCustom.CUSTOM.getCode();
            }

            TargetBriefingSetting targetBriefingSetting = new TargetBriefingSetting();
            targetBriefingSetting.setUserId(userId);
            targetBriefingSetting.setCreatedTime(createdTime);
            targetBriefingSetting.setGenerationTime(generationTime);
            targetBriefingSetting.setGenerationSyncTime(generationSyncTime);
            targetBriefingSetting.setBriefingType(briefingType);
            targetBriefingSetting.setTemplateType(templateType);
            targetBriefingSetting.setEnabledState(enabledState);
            targetBriefingSetting.setCustomState(customState);

            targetBriefingSettingService.save(targetBriefingSetting);
        }
        return size;
    }

    @Override
    protected Page<SourceBriefingSetting> getPageList(int pageNumber) {
        return sourceBriefingSettingService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

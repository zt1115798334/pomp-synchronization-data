package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceUser;
import com.example.pompsynchronizationdata.source.service.SourceUserService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadNewsGroup;
import com.example.pompsynchronizationdata.target.entity.TargetBriefingSetting;
import com.example.pompsynchronizationdata.target.entity.TargetWarningRule;
import com.example.pompsynchronizationdata.target.service.TargetAbroadNewsGroupService;
import com.example.pompsynchronizationdata.target.service.TargetBriefingSettingService;
import com.example.pompsynchronizationdata.target.service.TargetWarningRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/5 14:19
 * description: 添加系统中用户没有手动预警的
 */
@Component
public class UserRelatedSettingAdd extends PageHandler<SourceUser> {

    @Autowired
    private SourceUserService sourceUserService;

    @Autowired
    private TargetWarningRuleService targetWarningRuleService;

    @Autowired
    private TargetBriefingSettingService targetBriefingSettingService;

    @Autowired
    private TargetAbroadNewsGroupService targetAbroadNewsGroupService;

    @Override
    protected int handleDataOfPerPage(List<SourceUser> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceUser sourceUser = list.get(i);
            Long userId = sourceUser.getId();
//            Optional<TargetWarningRule> targetWarningRuleOptional = targetWarningRuleService.findHandleByUserId(userId);
//            if (!targetWarningRuleOptional.isPresent()) {   //如果不存在 则添加
//                saveSysHandleWarning(userId);
//            }
//            List<TargetBriefingSetting> targetBriefingSettingList = targetBriefingSettingService.findByUserId(userId);
//            if (targetBriefingSettingList == null || targetBriefingSettingList.size() == 0) {
//                saveSysBriefingSetting(userId);
//            }


        }
        return size;
    }

    @Override
    protected Page<SourceUser> getPageList(int pageNumber) {
        return sourceUserService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }


    private void saveSysHandleWarning(Long userId) {
        TargetWarningRule warningRule = new TargetWarningRule();
        warningRule.setRoleTitle("手动预警");
        warningRule.setUserId(userId);
        warningRule.setEnabledState(SysConst.EnabledState.ON.getCode());
        warningRule.setWarningType(SysConst.WarningType.ARTIFICIAL.getCode());
        warningRule.setEmotion(SysConst.Emotion.ALL.getType());
        warningRule.setSearchArea(SysConst.SearchArea.ALL.getType());
        warningRule.setRegion(SysConst.Region.ALL.getCode());
        warningRule.setCreatedTime(DateUtils.currentDateTime());
        warningRule.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());
        targetWarningRuleService.save(warningRule);
    }

    private void saveSysBriefingSetting(Long userId) {
        Integer ON = SysConst.EnabledState.ON.getCode();
        LocalDateTime currentDate = DateUtils.currentDateTime();
        Integer defaultCode = SysConst.BriefingCustom.DEFAULT.getCode();
        Integer currencyEditionCode = SysConst.TemplateType.CURRENCY_EDITION.getCode();
        Integer dayTime = 0;
        Integer weekTime = 1;
        Integer monthTime = 1;

        TargetBriefingSetting bsDay = new TargetBriefingSetting();
        bsDay.setUserId(userId);
        bsDay.setCreatedTime(currentDate);
        bsDay.setEnabledState(ON);
        bsDay.setBriefingType(SysConst.BriefingType.DAY.getType());
        bsDay.setTemplateType(currencyEditionCode);
        bsDay.setGenerationTime(dayTime);
        bsDay.setGenerationSyncTime(dayTime);
        bsDay.setCustomState(defaultCode);
        targetBriefingSettingService.save(bsDay);

        TargetBriefingSetting bsWeek = new TargetBriefingSetting();
        bsWeek.setUserId(userId);
        bsWeek.setCreatedTime(currentDate);
        bsWeek.setEnabledState(ON);
        bsWeek.setBriefingType(SysConst.BriefingType.WEEK.getType());
        bsWeek.setTemplateType(currencyEditionCode);
        bsWeek.setGenerationTime(weekTime);
        bsWeek.setGenerationSyncTime(dayTime);
        bsWeek.setCustomState(defaultCode);
        targetBriefingSettingService.save(bsWeek);

        TargetBriefingSetting bsMonth = new TargetBriefingSetting();
        bsMonth.setUserId(userId);
        bsMonth.setCreatedTime(currentDate);
        bsMonth.setEnabledState(ON);
        bsMonth.setBriefingType(SysConst.BriefingType.MONTH.getType());
        bsMonth.setTemplateType(currencyEditionCode);
        bsMonth.setGenerationTime(monthTime);
        bsMonth.setGenerationSyncTime(dayTime);
        bsMonth.setCustomState(defaultCode);
        targetBriefingSettingService.save(bsMonth);
    }


}

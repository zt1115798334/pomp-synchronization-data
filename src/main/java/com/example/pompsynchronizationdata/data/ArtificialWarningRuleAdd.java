package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceUser;
import com.example.pompsynchronizationdata.source.service.SourceUserService;
import com.example.pompsynchronizationdata.target.entity.TargetWarningRule;
import com.example.pompsynchronizationdata.target.service.TargetWarningRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

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
public class ArtificialWarningRuleAdd extends PageHandler<SourceUser> {

    @Autowired
    private SourceUserService sourceUserService;

    @Autowired
    private TargetWarningRuleService targetWarningRuleService;

    @Override
    protected int handleDataOfPerPage(List<SourceUser> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceUser sourceUser = list.get(i);
            Long userId = sourceUser.getId();
            Optional<TargetWarningRule> targetWarningRuleOptional = targetWarningRuleService.findHandleByUserId(userId);
            if (!targetWarningRuleOptional.isPresent()) {   //如果不存在 则添加
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

        }
        return size;
    }

    @Override
    protected Page<SourceUser> getPageList(int pageNumber) {
        return sourceUserService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }

}

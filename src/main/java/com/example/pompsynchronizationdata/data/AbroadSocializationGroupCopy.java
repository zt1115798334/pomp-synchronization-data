package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceAbroadMediaGroup;
import com.example.pompsynchronizationdata.source.service.SourceAbroadMediaGroupService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadSocializationGroup;
import com.example.pompsynchronizationdata.target.service.TargetAbroadSocializationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:22
 * description:
 */
@Component
public class AbroadSocializationGroupCopy extends PageHandler<SourceAbroadMediaGroup> {

    @Autowired
    private SourceAbroadMediaGroupService sourceAbroadMediaGroupService;

    @Autowired
    private TargetAbroadSocializationGroupService targetAbroadSocializationGroupService;

    @Override
    protected int handleDataOfPerPage(List<SourceAbroadMediaGroup> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceAbroadMediaGroup sourceAbroadMediaGroup = list.get(i);
            Long sourceAbroadMediaGroupId = sourceAbroadMediaGroup.getId();
            String sourceAbroadMediaGroupName = sourceAbroadMediaGroup.getName();
            Integer sourceAbroadMediaGroupOrderBy = sourceAbroadMediaGroup.getOrderBy();
            Integer sourceAbroadMediaGroupShowStatus = sourceAbroadMediaGroup.getShowStatus();
            Integer sourceAbroadMediaGroupUserId = sourceAbroadMediaGroup.getUserId();
            LocalDateTime sourceAbroadMediaGroupTime = sourceAbroadMediaGroup.getTime();
            Integer sourceAbroadMediaGroupCode = sourceAbroadMediaGroup.getCode();
            Long sourceAbroadMediaGroupParentId = sourceAbroadMediaGroup.getParentId();
            Integer sourceAbroadMediaGroupLevel = sourceAbroadMediaGroup.getLevel();
            Integer sourceAbroadMediaGroupIsDelete = sourceAbroadMediaGroup.getIsDelete();

            if (sourceAbroadMediaGroupOrderBy == null) {
                sourceAbroadMediaGroupOrderBy = 1;
            }

            Integer showState = SysConst.ShowState.DISPLAY.getCode();
            if (sourceAbroadMediaGroupShowStatus == 1) {//show
                showState = SysConst.ShowState.DISPLAY.getCode();
            }
            if (sourceAbroadMediaGroupShowStatus == 0) {//no show
                showState = SysConst.ShowState.HIDE.getCode();
            }
            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            if (sourceAbroadMediaGroupIsDelete == 0) {//no delete
                deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            }
            if (sourceAbroadMediaGroupIsDelete == 1) {// delete
                deleteState = SysConst.DeleteState.DELETE.getCode();
            }

            TargetAbroadSocializationGroup targetAbroadSocializationGroup = new TargetAbroadSocializationGroup();
            targetAbroadSocializationGroup.setId(sourceAbroadMediaGroupId);
            targetAbroadSocializationGroup.setUserId(Long.valueOf(sourceAbroadMediaGroupUserId));
            targetAbroadSocializationGroup.setGroupName(sourceAbroadMediaGroupName);
            targetAbroadSocializationGroup.setOrderBy(sourceAbroadMediaGroupOrderBy);
            targetAbroadSocializationGroup.setShowState(showState);
            targetAbroadSocializationGroup.setCreatedTime(sourceAbroadMediaGroupTime);
            targetAbroadSocializationGroup.setCode(sourceAbroadMediaGroupCode);
            targetAbroadSocializationGroup.setParentId(sourceAbroadMediaGroupParentId);
            targetAbroadSocializationGroup.setLevel(sourceAbroadMediaGroupLevel);
            targetAbroadSocializationGroup.setDeleteState(deleteState);

            targetAbroadSocializationGroupService.save(targetAbroadSocializationGroup);


        }
        return size;
    }

    @Override
    protected Page<SourceAbroadMediaGroup> getPageList(int pageNumber) {
        return sourceAbroadMediaGroupService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);

    }
}

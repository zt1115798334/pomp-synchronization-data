package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceFilterBox;
import com.example.pompsynchronizationdata.source.service.SourceFilterBoxService;
import com.example.pompsynchronizationdata.target.entity.TargetFilterBox;
import com.example.pompsynchronizationdata.target.service.TargetFilterBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 15:51
 * description:
 */
@Component
public class FilterBoxCopy extends PageHandler<SourceFilterBox> {

    @Autowired
    private SourceFilterBoxService sourceFilterBoxService;

    @Autowired
    private TargetFilterBoxService targetFilterBoxService;


    @Override
    protected int handleDataOfPerPage(List<SourceFilterBox> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceFilterBox sourceFilterBox = list.get(i);
            Long sourceFilterBoxUserId = sourceFilterBox.getUserId();
            String sourceFilterBoxContent = sourceFilterBox.getContent();
            Integer sourceFilterBoxType = sourceFilterBox.getType();
            Integer sourceFilterBoxStatus = sourceFilterBox.getStatus();
            LocalDateTime sourceFilterBoxTime = sourceFilterBox.getTime();
            Integer sourceFilterBoxIsDelete = sourceFilterBox.getIsDelete();

            Integer filterType = null;
            if (sourceFilterBoxType == 0) {//关键词
                filterType = SysConst.FilterType.KEYWORD.getCode();
            }
            if (sourceFilterBoxType == 1) {//来源
                filterType = SysConst.FilterType.SOURCE.getCode();
            }
            if (sourceFilterBoxType == 2) {//作者
                filterType = SysConst.FilterType.AUTHOR.getCode();
            }

            Integer enabledState = null;
            if (sourceFilterBoxStatus == 0) { //停用
                enabledState = SysConst.EnabledState.OFF.getCode();
            }
            if (sourceFilterBoxStatus == 1) { //启用
                enabledState = SysConst.EnabledState.ON.getCode();
            }
            Integer deleteState = null;
            if (sourceFilterBoxIsDelete == 0) {//未删除
                deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            } if (sourceFilterBoxIsDelete == 1) {//删除
                deleteState = SysConst.DeleteState.DELETE.getCode();

            }

            TargetFilterBox targetFilterBox = new TargetFilterBox();
            targetFilterBox.setUserId(sourceFilterBoxUserId);
            targetFilterBox.setContent(sourceFilterBoxContent);
            targetFilterBox.setFilterType(filterType);
            targetFilterBox.setEnabledState(enabledState);
            targetFilterBox.setCreatedTime(sourceFilterBoxTime);
            targetFilterBox.setDeleteState(deleteState);

            targetFilterBoxService.save(targetFilterBox);
        }
        return size;
    }

    @Override
    protected Page<SourceFilterBox> getPageList(int pageNumber) {
        return sourceFilterBoxService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

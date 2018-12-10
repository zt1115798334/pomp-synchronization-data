package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesGroup;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesGroupService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsiteGroup;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:29
 * description:
 */
@Component
public class AbroadWebsiteGroupCopy extends PageHandler<SourceOverseasSitesGroup> {

    @Autowired
    private SourceOverseasSitesGroupService sourceOverseasSitesGroupService;

    @Autowired
    private TargetAbroadWebsiteGroupService targetAbroadWebsiteGroupService;

    @Override
    protected int handleDataOfPerPage(List<SourceOverseasSitesGroup> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceOverseasSitesGroup sourceOverseasSitesGroup = list.get(i);
            Long sourceOverseasSitesGroupId = sourceOverseasSitesGroup.getId();
            Integer sourceOverseasSitesGroupIsDeleted = sourceOverseasSitesGroup.getIsDeleted();
            String sourceOverseasSitesGroupName = sourceOverseasSitesGroup.getName();
            Long sourceOverseasSitesGroupUserId = sourceOverseasSitesGroup.getUserId();

            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            if (sourceOverseasSitesGroupIsDeleted == 0) {// no delete
                deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            }
            if (sourceOverseasSitesGroupIsDeleted == 1) {//  delete
                deleteState = SysConst.DeleteState.DELETE.getCode();
            }


            TargetAbroadWebsiteGroup targetAbroadWebsiteGroup = new TargetAbroadWebsiteGroup();
            targetAbroadWebsiteGroup.setId(sourceOverseasSitesGroupId);
            targetAbroadWebsiteGroup.setDeleteState(deleteState);
            targetAbroadWebsiteGroup.setName(sourceOverseasSitesGroupName);
            targetAbroadWebsiteGroup.setUserId(sourceOverseasSitesGroupUserId);
            targetAbroadWebsiteGroupService.save(targetAbroadWebsiteGroup);
        }
        return size;
    }

    @Override
    protected Page<SourceOverseasSitesGroup> getPageList(int pageNumber) {
        return sourceOverseasSitesGroupService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

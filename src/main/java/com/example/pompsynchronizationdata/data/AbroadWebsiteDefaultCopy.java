package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesDefault;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesDefaultService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsiteDefault;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteDefaultService;
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
public class AbroadWebsiteDefaultCopy extends PageHandler<SourceOverseasSitesDefault> {

    @Autowired
    private SourceOverseasSitesDefaultService sourceOverseasSitesDefaultService;

    @Autowired
    private TargetAbroadWebsiteDefaultService targetAbroadWebsiteDefaultService;

    @Override
    protected int handleDataOfPerPage(List<SourceOverseasSitesDefault> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceOverseasSitesDefault sourceOverseasSitesDefault = list.get(i);
            String sourceOverseasSitesDefaultName = sourceOverseasSitesDefault.getName();
            String sourceOverseasSitesDefaultUrl = sourceOverseasSitesDefault.getUrl();
            Long sourceOverseasSitesDefaultGroupId = sourceOverseasSitesDefault.getGroupId();
            Integer sourceOverseasSitesDefaultDeleteState = sourceOverseasSitesDefault.getDeleteState();

            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            if (sourceOverseasSitesDefaultDeleteState == 1) { //delete
                deleteState = SysConst.DeleteState.DELETE.getCode();
            }
            if (sourceOverseasSitesDefaultDeleteState == 0) { //no delete
                deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            }


            TargetAbroadWebsiteDefault targetAbroadWebsiteDefault = new TargetAbroadWebsiteDefault();
            targetAbroadWebsiteDefault.setName(sourceOverseasSitesDefaultName);
            targetAbroadWebsiteDefault.setUrl(sourceOverseasSitesDefaultUrl);
            targetAbroadWebsiteDefault.setGroupId(sourceOverseasSitesDefaultGroupId);
            targetAbroadWebsiteDefault.setDeleteState(deleteState);

            targetAbroadWebsiteDefaultService.save(targetAbroadWebsiteDefault);

        }
        return size;
    }

    @Override
    protected Page<SourceOverseasSitesDefault> getPageList(int pageNumber) {
        return sourceOverseasSitesDefaultService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSitesGroupDefault;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesGroupDefaultService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsiteGroupDefault;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteGroupDefaultService;
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
public class AbroadWebsiteGroupDefaultCopy extends PageHandler<SourceOverseasSitesGroupDefault> {

    @Autowired
    private SourceOverseasSitesGroupDefaultService sourceOverseasSitesGroupDefaultService;

    @Autowired
    private TargetAbroadWebsiteGroupDefaultService targetAbroadWebsiteGroupDefaultService;

    @Override
    protected int handleDataOfPerPage(List<SourceOverseasSitesGroupDefault> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceOverseasSitesGroupDefault sourceOverseasSitesGroupDefault = list.get(i);
            Long sourceOverseasSitesGroupDefaultId = sourceOverseasSitesGroupDefault.getId();
            String sourceOverseasSitesGroupDefaultName = sourceOverseasSitesGroupDefault.getName();

            TargetAbroadWebsiteGroupDefault targetAbroadWebsiteGroupDefault = new TargetAbroadWebsiteGroupDefault();
            targetAbroadWebsiteGroupDefault.setId(sourceOverseasSitesGroupDefaultId);
            targetAbroadWebsiteGroupDefault.setName(sourceOverseasSitesGroupDefaultName);

            targetAbroadWebsiteGroupDefaultService.save(targetAbroadWebsiteGroupDefault);
        }
        return size;
    }

    @Override
    protected Page<SourceOverseasSitesGroupDefault> getPageList(int pageNumber) {
        return sourceOverseasSitesGroupDefaultService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

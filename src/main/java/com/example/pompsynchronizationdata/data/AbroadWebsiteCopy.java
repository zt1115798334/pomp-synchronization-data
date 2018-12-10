package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceOverseasSites;
import com.example.pompsynchronizationdata.source.service.SourceOverseasSitesService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadWebsite;
import com.example.pompsynchronizationdata.target.service.TargetAbroadWebsiteService;
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
public class AbroadWebsiteCopy extends PageHandler<SourceOverseasSites> {

    @Autowired
    private SourceOverseasSitesService sourceOverseasSitesService;

    @Autowired
    private TargetAbroadWebsiteService targetAbroadWebsiteService;

    @Override
    protected int handleDataOfPerPage(List<SourceOverseasSites> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceOverseasSites sourceOverseasSites = list.get(i);
            String sourceOverseasSitesName = sourceOverseasSites.getName();
            String sourceOverseasSitesUrl = sourceOverseasSites.getUrl();
            Long sourceOverseasSitesUserId = sourceOverseasSites.getUserId();
            Long sourceOverseasSitesGroupId = sourceOverseasSites.getGroupId();
            if (sourceOverseasSitesGroupId != null) {

                TargetAbroadWebsite targetAbroadWebsite = new TargetAbroadWebsite();
                targetAbroadWebsite.setGroupId(sourceOverseasSitesGroupId);
                targetAbroadWebsite.setUserId(sourceOverseasSitesUserId);
                targetAbroadWebsite.setUrl(sourceOverseasSitesUrl);
                targetAbroadWebsite.setName(sourceOverseasSitesName);
                targetAbroadWebsiteService.save(targetAbroadWebsite);
            }

        }
        return size;
    }

    @Override
    protected Page<SourceOverseasSites> getPageList(int pageNumber) {
        return sourceOverseasSitesService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

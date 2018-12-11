package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceSite;
import com.example.pompsynchronizationdata.source.service.SourceSiteService;
import com.example.pompsynchronizationdata.target.entity.TargetSite;
import com.example.pompsynchronizationdata.target.service.TargetSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 10:59
 * description:
 */
@Component
public class SiteCopy extends PageHandler<SourceSite> {

    @Autowired
    private SourceSiteService sourceSiteService;

    @Autowired
    private TargetSiteService targetSiteService;

    @Override
    protected int handleDataOfPerPage(List<SourceSite> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceSite sourceSite = list.get(i);
            Long sourceSiteId = sourceSite.getId();
            Long sourceSiteUserId = sourceSite.getUserId();
            String sourceSiteColumns = sourceSite.getColumns();
            String sourceSiteUrl = sourceSite.getUrl();
            String sourceSiteName = sourceSite.getName();
            LocalDateTime sourceSiteTime = sourceSite.getTime();
            Integer sourceSiteStatus = sourceSite.getStatus();
            Integer sourceSiteSiteType = sourceSite.getSiteType();
            Integer sourceSiteSiteNature = sourceSite.getSiteNature();
            Integer sourceSiteIsword = sourceSite.getIsword();

            TargetSite targetSite = new TargetSite();
            targetSite.setId(sourceSiteId);
            targetSite.setUserId(sourceSiteUserId);
            targetSite.setSiteName(sourceSiteName);
            targetSite.setSiteUrl(sourceSiteUrl);
            targetSite.setCreatedTime(sourceSiteTime);
            targetSite.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());

            targetSiteService.save(targetSite);


        }
        return size;
    }

    @Override
    protected Page<SourceSite> getPageList(int pageNumber) {
        return sourceSiteService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

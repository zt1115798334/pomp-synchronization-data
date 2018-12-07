package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceUserApp;
import com.example.pompsynchronizationdata.source.service.SourceUserAppService;
import com.example.pompsynchronizationdata.target.entity.TargetUserApp;
import com.example.pompsynchronizationdata.target.service.TargetUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/7 10:18
 * description:
 */
@Component
public class UserAppCopy extends PageHandler<SourceUserApp> {

    @Autowired
    private SourceUserAppService sourceUserAppService;

    @Autowired
    private TargetUserAppService targetUserAppService;

    @Override
    protected int handleDataOfPerPage(List<SourceUserApp> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceUserApp sourceUserApp = list.get(i);
            Long sourceUserAppUserId = sourceUserApp.getUserId();
            Long sourceUserAppMenuId = sourceUserApp.getMenuId();
            String sourceUserAppName = sourceUserApp.getName();
            Integer sourceUserAppIsCustom = sourceUserApp.getIsCustom();
            LocalDateTime sourceUserAppCreatedTime = sourceUserApp.getCreatedTime();
            Long menuId = null;
            if (sourceUserAppMenuId == 1019L) { //云搜索
                menuId = SysConst.MenuApp.APP_CLOUD_SEARCH_INDEX.getCode();
            }
            if (sourceUserAppMenuId == 1020L) { //网站巡查
                menuId = SysConst.MenuApp.APP_SITE.getCode();

            }
            if (sourceUserAppMenuId == 1021L) { //智能图表
                menuId = SysConst.MenuApp.APP_PUBLIC_SENTIMENT_CHART.getCode();

            }
            if (sourceUserAppMenuId == 1022L) { //舆情大屏
                menuId = SysConst.MenuApp.APP_BIG_SCREEN.getCode();

            }
            if (sourceUserAppMenuId == 1023L) { //境外新闻媒体监测
                menuId = SysConst.MenuApp.APP_ABROAD_NEWS.getCode();

            }
            if (sourceUserAppMenuId == 1024L) { //多语言监测
                menuId = SysConst.MenuApp.APP_LANGUAGE.getCode();

            }
            if (sourceUserAppMenuId == 1025L) { //网民聚焦

            }
            if (sourceUserAppMenuId == 1026L) { //博主监测

            }
            if (sourceUserAppMenuId == 1027L) { //商品监测

            }
            if (sourceUserAppMenuId == 1028L) { //群监测

            }
            if (sourceUserAppMenuId == 1029L) { //身份落地

            }
            if (sourceUserAppMenuId == 1030L) { //LBS信息采集

            }
            if (sourceUserAppMenuId == 1031L) { //网络态势感知

            }
            if (sourceUserAppMenuId == 1032L) { //属地网站管控

            }
            if (sourceUserAppMenuId == 1033L) { //网络评论管理

            }
            if (sourceUserAppMenuId == 1034L) { //境外网址导航
                menuId = SysConst.MenuApp.APP_ABROAD_WEBSITE.getCode();

            }
            if (sourceUserAppMenuId == 1035L) { //评论分析
                menuId = SysConst.MenuApp.APP_COMMENT_ANALYSIS.getCode();

            }
            if (sourceUserAppMenuId == 1036L) { //微信公众号监测

            }
            if (sourceUserAppMenuId == 1037L) { //群组监测

            }
            if (sourceUserAppMenuId == 1038L) { //两微监测

            }
            if (sourceUserAppMenuId == 1039L) { //对比分析

            }
            if (sourceUserAppMenuId == 1040L) { //境外社交媒体分析

            }
            if (sourceUserAppMenuId == 1041L) { //舆情管家APP
                menuId = SysConst.MenuApp.APP_APP.getCode();

            }
            if (sourceUserAppMenuId == 1042L) { //境外网址导航

            }
            if (sourceUserAppMenuId == 1043L) { //舆情热点排行榜

            }
            if (sourceUserAppMenuId == 1044L) { //境外社交媒体监测
                menuId = SysConst.MenuApp.APP_ABROAD_SOCIALIZATION.getCode();

            }
            if (sourceUserAppMenuId == 1045L) { //网站频道巡查
                menuId = SysConst.MenuApp.APP_SITE_CHANNEL.getCode();

            }
            Integer showState = SysConst.ShowState.HIDE.getCode();
            if (sourceUserAppIsCustom == 0) {//不展示
                showState = SysConst.ShowState.HIDE.getCode();
            }
            if (sourceUserAppIsCustom == 1) { //展示
                showState = SysConst.ShowState.DISPLAY.getCode();
            }

            if (menuId != null) {
                TargetUserApp targetUserApp = new TargetUserApp();
                targetUserApp.setUserId(sourceUserAppUserId);
                targetUserApp.setMenuId(menuId);
                targetUserApp.setShowState(showState);
                sourceUserAppCreatedTime =  sourceUserAppCreatedTime == null ? DateUtils.currentDateTime() : sourceUserAppCreatedTime;
                targetUserApp.setCreatedTime(sourceUserAppCreatedTime);
                targetUserAppService.save(targetUserApp);
            }
        }
        return size;
    }

    @Override
    protected Page<SourceUserApp> getPageList(int pageNumber) {
        return sourceUserAppService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}

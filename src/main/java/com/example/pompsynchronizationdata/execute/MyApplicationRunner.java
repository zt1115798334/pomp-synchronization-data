package com.example.pompsynchronizationdata.execute;

import com.example.pompsynchronizationdata.data.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/3 11:45
 * description:
 */
@Component
@Slf4j
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserCopy userCopy;

    @Autowired
    private WarningNoticeCopy warningNoticeCopy;

    @Autowired
    private WarningRuleCopy warningRuleCopy;


    @Autowired
    private WarningCopy warningCopy;

    @Autowired
    private FavoritesCopy favoritesCopy;

    @Autowired
    private ColumnCopy columnCopy;

    @Autowired
    private ColumnSpecialCopy columnSpecialCopy;

    @Autowired
    private EventCopy eventCopy;

    @Autowired
    private BriefingNoticeCopy briefingNoticeCopy;
    @Autowired
    private BriefingSettingCopy briefingSettingCopy;

    @Autowired
    private BriefingCopy briefingCopy;

    @Autowired
    private ClearBriefingData clearBriefingData;

    @Autowired
    private BriefingArticleMediaCopy briefingArticleMediaCopy;

    @Autowired
    private BriefingArticleCurrencyCopy briefingArticleCurrencyCopy;

    @Autowired
    private BriefingTemplateCopy briefingTemplateCopy;

    @Autowired
    private FilterBoxCopy filterBoxCopy;

    @Autowired
    private UserAppCopy userAppCopy;

    @Autowired
    private UserTokenCopy userTokenCopy;

    @Autowired
    private CommentAnalysisCopy commentAnalysisCopy;

    @Autowired
    private CommentAnalysisUserCopy commentAnalysisUserCopy;

    @Autowired
    private UserRelatedSettingAdd userRelatedSettingAdd;

    @Autowired
    private AbroadWebsiteGroupDefaultCopy abroadWebsiteGroupDefaultCopy;

    @Autowired
    private AbroadWebsiteDefaultCopy abroadWebsiteDefaultCopy;

    @Autowired
    private AbroadWebsiteGroupCopy abroadWebsiteGroupCopy;

    @Autowired
    private AbroadWebsiteCopy abroadWebsiteCopy;

    @Autowired
    private AbroadNewsSetCopy abroadNewsSetCopy;

    @Autowired
    private MessageCopy messageCopy;

    @Autowired
    private MessageReadCopy messageReadCopy;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始同步数据了...");

//        log.info("step 1 -- 开始同步用户信息数据...");
//        userCopy.handle();

//        log.info("step 2 -- 开始同步预警通知信息数据...");
//        warningNoticeCopy.handle();

//        log.info("-- 开始同步预警规则信息数据...");
//        warningRuleCopy.handle();

//        log.info("-- 开始同步预警文章信息数据...");
//        warningCopy.handle();
//
//        log.info("step 3 -- 开始同步收藏文章信息数据...");
//        favoritesCopy.handle();

//        log.info("step 4 -- 开始同步专题分组信息数据...");
//        columnCopy.handle();
//        log.info("-- 开始同步专题信息数据...");
//        columnSpecialCopy.handle();
//
//        log.info("step 5 -- 开始同步事件信息数据...");
//        eventCopy.handle();
//
//        log.info("step 6 -- 开始同步报告通知人信息数据...");
//        briefingNoticeCopy.handle();
//
//        log.info("-- 开始同步报告设置信息数据...");
//        briefingSettingCopy.handle();
//
//        log.info("-- 开始同步报告信息数据...");
//        briefingCopy.handle();
//
//        log.info("-- 开始清洗报告信息数据，只保留近三个月数据...");
//        clearBriefingData.handle();
//
//        log.info("-- 开始同步媒体报告文章信息数据...");
//        briefingArticleMediaCopy.handle();
//
//        log.info("-- 开始同步通用报告文章信息数据...");
//        briefingArticleCurrencyCopy.handle();
//
//        log.info("-- 开始同步通用报告模板信息初始化数据...");
//        briefingTemplateCopy.handle();

//        log.info("step 7 -- 开始同步过滤信息初始化数据...");
//        filterBoxCopy.handle();
//
//        log.info("step 8 -- 开始同步订阅app信息初始化数据...");
//        userAppCopy.handle();

//        log.info("step 9 -- 开始同步UserToken信息初始化数据...");
//        userTokenCopy.handle();

//        log.info("step 10 -- 开始同步评论分析相关信息初始化数据...");
//        commentAnalysisCopy.handle();

//        log.info("-- 开始同步评论分析用户信息初始化数据...");
//        commentAnalysisUserCopy.handle();

//        log.info("step 11 -- 开始同步默认境外站点导航分组信息初始化数据...");
//        abroadWebsiteGroupDefaultCopy.handle();
//        log.info("-- 开始同步默认境外站点导航信息初始化数据...");
//        abroadWebsiteDefaultCopy.handle();
//        log.info("-- 开始同步境外站点导航分组信息初始化数据...");
//        abroadWebsiteGroupCopy.handle();
//        log.info("-- 开始同步境外站点导航信息初始化数据...");
//        abroadWebsiteCopy.handle();
//
//        log.info("step 12 -- 开始同步境外新闻监测数据");
//        abroadNewsSetCopy.handle();
//
        log.info("step 13 -- 开始同步消息数据");
        messageCopy.handle();
        log.info("-- 开始同步消息阅读数据");
        messageReadCopy.handle();


//        log.info("step 999 -- 开始添加用户信息");
//        userRelatedSettingAdd.handle();  //他需要warningRuleCopy.handle(); 执行后执行，同时修改实体类TargetWarningRule 继承IdIdentityEntity


    }
}

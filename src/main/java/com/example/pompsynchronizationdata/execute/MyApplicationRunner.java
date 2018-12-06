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
    private UserRelatedSettingAdd userRelatedSettingAdd;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始同步数据了...");

//        log.info("step 1 -- 开始同步用户信息数据...");
//        userCopy.handle();

//        log.info("step 2 -- 开始同步预警通知信息数据...");
//        warningNoticeCopy.handle();

//        log.info("step 3 -- 开始同步预警规则信息数据...");
//        warningRuleCopy.handle();

//        log.info("step 4 -- 开始同步预警文章信息数据...");
//        warningCopy.handle();

//        log.info("step 5 -- 开始同步收藏文章信息数据...");
//        favoritesCopy.handle();

//        log.info("step 6 -- 开始同步专题分组信息数据...");
//        columnCopy.handle();

//        log.info("step 7 -- 开始同步专题信息数据...");
//        columnSpecialCopy.handle();

//        log.info("step 8 -- 开始同步事件信息数据...");
//        eventCopy.handle();

//        log.info("step 9 -- 开始同步报告通知人信息数据...");
//        briefingNoticeCopy.handle();

//        log.info("step 10 -- 开始同步报告设置信息数据...");
//        briefingSettingCopy.handle();


        log.info("step 999 -- 开始添加用户的手动预警信息，存在的则不添加");
        userRelatedSettingAdd.handle();  //他需要warningRuleCopy.handle(); 执行后执行，同时修改实体类TargetWarningRule 继承IdIdentityEntity


    }
}

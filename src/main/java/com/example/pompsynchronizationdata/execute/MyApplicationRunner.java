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
    private ArtificialWarningRuleAdd artificialWarningRuleAdd;

    @Autowired
    private WarningCopy warningCopy;

    @Autowired
    private FavoritesCopy favoritesCopy;

    @Autowired
    private ColumnCopy columnCopy;

    @Autowired
    private ColumnSpecialCopy columnSpecialCopy;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始同步数据了...");

//        log.info("开始同步用户信息数据...");
//        userCopy.handle();

//        log.info("开始同步预警通知信息数据...");
//        warningNoticeCopy.handle();

        log.info("开始同步预警规则信息数据...");
        warningRuleCopy.handle();

//        log.info("开始添加用户的手动预警信息，存在的则不添加");
//        artificialWarningRuleAdd.handle();  //他需要warningRuleCopy.handle(); 执行后执行，同时修改实体类TargetWarningRule 继承IdIdentityEntity

//        log.info("开始同步预警文章信息数据...");
//        warningCopy.handle();

//        log.info("开始同步收藏文章信息数据...");
//        favoritesCopy.handle();
//        log.info("开始同步专题分组信息数据...");
//        columnCopy.handle();

//        log.info("开始同步专题信息数据...");
//        columnSpecialCopy.handle();


    }
}

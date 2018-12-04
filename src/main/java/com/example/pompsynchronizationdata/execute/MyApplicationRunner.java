package com.example.pompsynchronizationdata.execute;

import com.example.pompsynchronizationdata.data.UserCopy;
import com.example.pompsynchronizationdata.data.WarningCopy;
import com.example.pompsynchronizationdata.data.WarningNoticeCopy;
import com.example.pompsynchronizationdata.data.WarningRuleCopy;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始同步数据了...");

//        log.info("开始同步用户信息数据...");
//        userCopy.handle();

//        log.info("开始同步预警通知信息数据...");
//        warningNoticeCopy.handle();
//        log.info("开始同步预警规则信息数据...");
//        warningRuleCopy.handle();

        log.info("开始同步预警文章信息数据...");
        warningCopy.handle();

    }
}

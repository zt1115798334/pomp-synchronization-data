package com.example.pompsynchronizationdata.execute;

import com.example.pompsynchronizationdata.data.UserCopy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.FutureTask;

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始同步数据了...");

        new FutureTask<>(() -> {
            System.out.println("MyApplicationRunner.run");
            userCopy.handle();
            return 0;
        }).run();

    }
}

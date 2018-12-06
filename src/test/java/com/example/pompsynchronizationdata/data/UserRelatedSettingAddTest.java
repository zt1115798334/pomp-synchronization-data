package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.PompSynchronizationDataApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/5 14:33
 * description:
 */
public class UserRelatedSettingAddTest extends PompSynchronizationDataApplicationTests {

    @Autowired
    private UserRelatedSettingAdd userRelatedSettingAdd;
    @Test
    public void handle() {
        userRelatedSettingAdd.handle();
    }
}
package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.PompSynchronizationDataApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/5 14:33
 * description:
 */
public class ArtificialWarningRuleAddTest extends PompSynchronizationDataApplicationTests {

    @Autowired
    private ArtificialWarningRuleAdd artificialWarningRuleAdd;
    @Test
    public void handle() {
        artificialWarningRuleAdd.handle();
    }
}
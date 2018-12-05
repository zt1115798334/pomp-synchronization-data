package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.PompSynchronizationDataApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/5 14:38
 * description:
 */
public class WarningRuleCopyTest extends PompSynchronizationDataApplicationTests {
    @Autowired
    private WarningRuleCopy warningRuleCopy;

    @Test
    public void handle() {
        warningRuleCopy.handle();
    }
}
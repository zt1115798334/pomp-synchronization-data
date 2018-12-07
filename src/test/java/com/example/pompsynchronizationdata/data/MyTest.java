package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.PompSynchronizationDataApplicationTests;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceWarning;
import com.example.pompsynchronizationdata.source.service.SourceWarningService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/7 14:39
 * description:
 */
public class MyTest extends PompSynchronizationDataApplicationTests {

    @Autowired
    private SourceWarningService sourceWarningService;

    @Test
    public void test1() {
        Page<SourceWarning> pageByEntity = sourceWarningService.findPageByEntity(1, SysConst.DEFAULT_BATCH_SIZE);
        System.out.println(pageByEntity.getTotalPages());
    }
}

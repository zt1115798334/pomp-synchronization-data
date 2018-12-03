package com.example.pompsynchronizationdata;

import com.example.pompsynchronizationdata.source.entity.SourceUser;
import com.example.pompsynchronizationdata.source.repo.SourceUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PompSynchronizationDataApplicationTests {

    @Autowired
    private SourceUserRepository sourceUserRepository;
    @Test
    public void contextLoads() {
        Iterable<SourceUser> all = sourceUserRepository.findAll();
        System.out.println("all = " + all);
    }

}

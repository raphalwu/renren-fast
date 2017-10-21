package io.renren.base;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BaseServiceTest {


    @Before
    public void beforeTest(){
     System.out.println("BEFORE JUNIT TEST");
    }
    @After
    public  void afterTest(){
        System.out.println("AFTER JUNIT TEST");
    }


}

package io.renren.erp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.renren.erp.dao.entity.base.User;
import io.renren.erp.service.ErpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
 
   @Autowired
   private ErpService erpService;
	
    @Test
    public void test(){
    	List<User> list = erpService.listUser();
    	System.out.println(list);
    	
    }
}

package io.renren;

import io.renren.base.BaseServiceTest;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.service.SysMenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class MenuServiceTest extends BaseServiceTest {
    @Autowired
    private SysMenuService sysMenuService;

    @Test
//    @Transactional
   public  void saveMenuTest(){
       SysMenuEntity menu = new SysMenuEntity();
       menu.setName("一级菜单-测试");
       menu.setParentId(-1L);
       menu.setOpen(true);

       sysMenuService.save(menu);
   }
}

package io.renren.modules.api.test;

import io.renren.common.annotation.SysLog;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/test/")
//@Api(tags = "api测试，增删改查规范")
@Api(value = "Test", description = "api测试，增删改查规范")
public class TestController {
    @Autowired
    private SysMenuService sysMenuService;
    /**
     * 所有菜单列表
     */
    @ApiOperation("所有菜单列表")
    @GetMapping("list")
    public List<SysMenuEntity> list(){
        List<SysMenuEntity> menuList = sysMenuService.queryList(new HashMap<String, Object>());

        return menuList;
    }
    /**
     * 保存
     */
    @SysLog("保存菜单")
    @ApiOperation("保存菜单")
    @PostMapping("save")
    public R save(@RequestBody SysMenuEntity menu){
        //数据校验
        verifyForm(menu);

        sysMenuService.save(menu);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改菜单")
    @ApiOperation("修改菜单")
    @PutMapping("update")
//    @RequiresPermissions("sys:menu:update")
    public R update(@RequestBody SysMenuEntity menu){
        //数据校验
        verifyForm(menu);

        sysMenuService.update(menu);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除菜单")
    @ApiOperation("删除菜单")
    @DeleteMapping("delete")
//    @RequiresPermissions("sys:menu:delete")
    public R delete(long menuId){
        if(menuId <= 30){
            return R.error("系统菜单，不能删除");
        }

        sysMenuService.deleteBatch(new Long[]{menuId});

        return R.ok();
    }

    /**
     * 验证参数是否正确
     * 柔和处理
     */
    private void verifyForm(SysMenuEntity menu){
        if(StringUtils.isBlank(menu.getName())){
            throw new RRException("菜单名称不能为空");
        }

        //菜单
        if(menu.getType() == Constant.MenuType.MENU.getValue()){
            if(StringUtils.isBlank(menu.getUrl())){
                throw new RRException("菜单URL不能为空");
            }
        }
    }
}

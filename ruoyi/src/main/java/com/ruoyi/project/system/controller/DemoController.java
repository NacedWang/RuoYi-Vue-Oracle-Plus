package com.ruoyi.project.system.controller;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.Demo;
import com.ruoyi.project.system.service.IDemoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * DemoController
 *
 * @author ruoyi
 * @date 2020-06-24
 */
@AllArgsConstructor
@RestController
@RequestMapping("/system/demo" )
public class DemoController extends BaseController {

    @Autowired
    private IDemoService iDemoService;

    /**
     * 查询Demo列表
     */
    @PreAuthorize("@ss.hasPermi('system:demo:list')")
    @GetMapping("/list")
    public TableDataInfo list(Demo demo)
    {
        startPage();
        LambdaQueryWrapper<Demo> lqw = new LambdaQueryWrapper<Demo>();
        if (StringUtils.isNotBlank(demo.getName())){
            lqw.like(Demo::getName ,demo.getName());
        }
        if (demo.getApplyTime() != null){
            lqw.eq(Demo::getApplyTime ,demo.getApplyTime());
        }
        if (demo.getCount() != null){
            lqw.eq(Demo::getCount ,demo.getCount());
        }
        List<Demo> list = iDemoService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出Demo列表
     */
    @PreAuthorize("@ss.hasPermi('system:demo:export')" )
    @Log(title = "Demo" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(Demo demo) {
        LambdaQueryWrapper<Demo> lqw = new LambdaQueryWrapper<Demo>(demo);
        List<Demo> list = iDemoService.list(lqw);
        ExcelUtil<Demo> util = new ExcelUtil<Demo>(Demo. class);
        return util.exportExcel(list, "demo" );
    }

    /**
     * 获取Demo详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:demo:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) String id) {
        return AjaxResult.success(iDemoService.getById(id));
    }

    /**
     * 新增Demo
     */
    @PreAuthorize("@ss.hasPermi('system:demo:add')" )
    @Log(title = "Demo" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Demo demo) {
        demo.setId(IdUtil.simpleUUID());
        return toAjax(iDemoService.save(demo) ? 1 : 0);
    }

    /**
     * 修改Demo
     */
    @PreAuthorize("@ss.hasPermi('system:demo:edit')" )
    @Log(title = "Demo" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Demo demo) {
        return toAjax(iDemoService.updateById(demo) ? 1 : 0);
    }

    /**
     * 删除Demo
     */
    @PreAuthorize("@ss.hasPermi('system:demo:remove')" )
    @Log(title = "Demo" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(iDemoService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}

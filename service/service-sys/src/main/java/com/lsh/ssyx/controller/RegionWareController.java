package com.lsh.ssyx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.ssyx.model.sys.RegionWare;
import com.lsh.ssyx.result.Result;
import com.lsh.ssyx.service.RegionWareService;
import com.lsh.ssyx.vo.sys.RegionWareQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shaohua.liu
 * Create at 2023/7/20
 */
@Api(value = "区域仓库管理", tags = "区域仓库管理")
@RestController
@RequestMapping(value="/admin/sys/regionWare")
@CrossOrigin
public class RegionWareController {

    @Resource
    private RegionWareService regionWareService;

    /**
     * 开通区域列表
     * @param page
     * @param limit
     * @param regionWareQueryVo
     * @return
     */
    @ApiOperation(value = "获取开通区域列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "regionWareVo", value = "查询对象", required = false)
                    RegionWareQueryVo regionWareQueryVo) {

        Page<RegionWare> pageParam = new Page<>(page, limit);

        IPage<RegionWare> pageModel = regionWareService.selectPage(pageParam, regionWareQueryVo);

        return Result.ok(pageModel);
    }

    /**
     * 添加开通区域
     */
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody RegionWare regionWare) {
        regionWareService.saveRegionWare(regionWare);
        return Result.ok();
    }

    @ApiOperation("删除开通区域")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        regionWareService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation("取消开通区域")
    @PostMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id,
            @PathVariable Integer status) {
        regionWareService.updateStatus(id,status);
        return Result.ok(null);
    }
}

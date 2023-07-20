package com.lsh.ssyx.controller;

import com.lsh.ssyx.result.Result;
import com.lsh.ssyx.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shaohua.liu
 * Create at 2023/7/20
 */
@Api(tags = "区域管理")
@RestController
@RequestMapping("/admin/sys/region")
@CrossOrigin
public class RegionController {

    @Resource
    private RegionService regionService;

    @ApiOperation(value = "根据关键字获取地区列表")
    @GetMapping("findRegionByKeyword/{keyword}")
    public Result findSkuInfoByKeyword(@PathVariable("keyword") String keyword) {
        return Result.ok(regionService.findRegionByKeyword(keyword));
    }
}

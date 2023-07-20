package com.lsh.ssyx.controller;

import com.lsh.ssyx.result.Result;
import com.lsh.ssyx.service.WareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shaohua.liu
 * Create at 2023/7/20
 */
@Api(value = "仓库管理", tags = "仓库管理")
@RestController
@RequestMapping(value="/admin/sys/ware")
@CrossOrigin
public class WareController {

    @Resource
    private WareService wareService;

    @ApiOperation(value = "获取全部仓库")
    @GetMapping("findAllList")
    public Result findAllList() {
        return Result.ok(wareService.list());
    }
}

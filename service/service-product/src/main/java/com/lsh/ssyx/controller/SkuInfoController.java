package com.lsh.ssyx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.ssyx.model.product.SkuInfo;
import com.lsh.ssyx.result.Result;
import com.lsh.ssyx.service.SkuInfoService;
import com.lsh.ssyx.vo.product.SkuInfoQueryVo;
import com.lsh.ssyx.vo.product.SkuInfoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shaohua.liu
 * Create at 2023/7/31
 */
@RestController
@RequestMapping("/admin/product/skuInfo")
@CrossOrigin
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation("sku列表")
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page,
            @PathVariable Long limit,
            SkuInfoQueryVo skuInfoQueryVo) {
        Page<SkuInfo> pageParam = new Page<>(page, limit);
        IPage<SkuInfo> pageModel = skuInfoService.selectPageSkuInfo(pageParam, skuInfoQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation("添加商品sku信息")
    @PostMapping("save")
    public Result save(@RequestBody SkuInfoVo skuInfoVo) {
        skuInfoService.saveSkuInfo(skuInfoVo);
        return Result.ok(null);
    }

    @ApiOperation("获取sku信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SkuInfoVo skuInfoVo = skuInfoService.getSkuInfo(id);
        return Result.ok(skuInfoVo);
    }

    @ApiOperation("修改sku")
    @PutMapping("update")
    public Result update(@RequestBody SkuInfoVo skuInfoVo) {
        skuInfoService.updateSkuInfo(skuInfoVo);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        skuInfoService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        skuInfoService.removeByIds(idList);
        return Result.ok(null);
    }

    @ApiOperation("商品审核")
    @GetMapping("check/{skuId}/{status}")
    public Result check(@PathVariable Long skuId,
            @PathVariable Integer status) {
        skuInfoService.check(skuId, status);
        return Result.ok(null);
    }

    @ApiOperation("商品上下架")
    @GetMapping("publish/{skuId}/{status}")
    public Result publish(@PathVariable Long skuId,
            @PathVariable Integer status) {
        skuInfoService.publish(skuId, status);
        return Result.ok(null);
    }

    @GetMapping("isNewPerson/{skuId}/{status}")
    public Result isNewPerson(@PathVariable("skuId") Long skuId,
            @PathVariable("status") Integer status) {
        skuInfoService.isNewPerson(skuId, status);
        return Result.ok(null);
    }
}

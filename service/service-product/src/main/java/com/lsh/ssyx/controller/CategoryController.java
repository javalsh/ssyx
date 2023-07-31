package com.lsh.ssyx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.ssyx.model.product.Category;
import com.lsh.ssyx.result.Result;
import com.lsh.ssyx.service.CategoryService;
import com.lsh.ssyx.vo.product.CategoryQueryVo;
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
@RequestMapping("/admin/product/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 商品分类列表
     */
    @ApiOperation("商品分类列表")
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page,
            @PathVariable Long limit,
            CategoryQueryVo categoryQueryVo) {
        Page<Category> pageParam = new Page<>(page,limit);
        IPage<Category> pageModel = categoryService.selectPageCategory(pageParam,categoryQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取商品分类信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        return Result.ok(category);
    }

    @ApiOperation(value = "新增商品分类")
    @PostMapping("save")
    public Result save(@RequestBody Category category) {
        categoryService.save(category);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改商品分类")
    @PutMapping("update")
    public Result updateById(@RequestBody Category category) {
        categoryService.updateById(category);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除商品分类")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        categoryService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation(value = "根据id列表删除商品分类")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        categoryService.removeByIds(idList);
        return Result.ok(null);
    }

    /**
     * 查询所有商品分类
     */
    @ApiOperation("查询所有商品分类")
    @GetMapping("findAllList")
    public Result findAllList() {
        return Result.ok(categoryService.findAllList());
    }
}

package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.ssyx.model.product.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.vo.product.CategoryQueryVo;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【category(商品三级分类)】的数据库操作Service
* @createDate 2023-07-31 16:56:44
*/
public interface CategoryService extends IService<Category> {

    /**
     * 商品分类列表
     * @param pageParam 参数
     * @param categoryQueryVo 参数
     * @return 返回结果
     */
    IPage<Category> selectPageCategory(Page<Category> pageParam, CategoryQueryVo categoryQueryVo);

    /**
     * 查询所有商品分类
     * @return 返回结果
     */
    List<Category> findAllList();
}

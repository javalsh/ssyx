package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.Category;
import com.lsh.ssyx.service.CategoryService;
import com.lsh.ssyx.mapper.CategoryMapper;
import com.lsh.ssyx.vo.product.CategoryQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【category(商品三级分类)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Override
    public IPage<Category> selectPageCategory(Page<Category> pageParam, CategoryQueryVo categoryQueryVo) {
        String name = categoryQueryVo.getName();
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            wrapper.like(Category::getName,name);
        }
        return baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public List<Category> findAllList() {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);
        return this.list(queryWrapper);
    }
}





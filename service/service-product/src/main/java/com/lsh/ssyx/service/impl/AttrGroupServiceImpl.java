package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.AttrGroup;
import com.lsh.ssyx.service.AttrGroupService;
import com.lsh.ssyx.mapper.AttrGroupMapper;
import com.lsh.ssyx.vo.product.AttrGroupQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【attr_group(属性分组)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup>
    implements AttrGroupService{

    @Override
    public IPage<AttrGroup> selectPageAttrGroup(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo) {
        String name = attrGroupQueryVo.getName();
        LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(AttrGroup::getName,name);
        }
        return baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public List<AttrGroup> findAllListAttrGroup() {
        return this.list();
    }
}





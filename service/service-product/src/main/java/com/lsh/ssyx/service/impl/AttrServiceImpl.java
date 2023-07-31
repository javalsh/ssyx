package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.Attr;
import com.lsh.ssyx.service.AttrService;
import com.lsh.ssyx.mapper.AttrMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【attr(商品属性)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr>
    implements AttrService{

    @Override
    public List<Attr> getAttrListByGroupId(Long groupId) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getAttrGroupId,groupId);
        return baseMapper.selectList(wrapper);
    }
}





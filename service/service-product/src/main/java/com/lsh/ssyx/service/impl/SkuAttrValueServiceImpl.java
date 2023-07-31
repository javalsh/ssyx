package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.SkuAttrValue;
import com.lsh.ssyx.service.SkuAttrValueService;
import com.lsh.ssyx.mapper.SkuAttrValueMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【sku_attr_value(spu属性值)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class SkuAttrValueServiceImpl extends ServiceImpl<SkuAttrValueMapper, SkuAttrValue>
    implements SkuAttrValueService{

    @Override
    public List<SkuAttrValue> getAttrValueListBySkuId(Long id) {
        LambdaQueryWrapper<SkuAttrValue> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SkuAttrValue::getSkuId,id);
        return baseMapper.selectList(wrapper);
    }
}





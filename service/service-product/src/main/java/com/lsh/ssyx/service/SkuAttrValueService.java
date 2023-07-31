package com.lsh.ssyx.service;

import com.lsh.ssyx.model.product.SkuAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【sku_attr_value(spu属性值)】的数据库操作Service
* @createDate 2023-07-31 16:56:44
*/
public interface SkuAttrValueService extends IService<SkuAttrValue> {

    /**
     * 根据id查询商品属性信息列表
     * @param id
     * @return
     */
    List<SkuAttrValue> getAttrValueListBySkuId(Long id);
}

package com.lsh.ssyx.service;

import com.lsh.ssyx.model.product.Attr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【attr(商品属性)】的数据库操作Service
* @createDate 2023-07-31 16:56:44
*/
public interface AttrService extends IService<Attr> {

    /**
     * 根据平台属性分组id查询
     * @param groupId
     * @return
     */
    List<Attr> getAttrListByGroupId(Long groupId);
}

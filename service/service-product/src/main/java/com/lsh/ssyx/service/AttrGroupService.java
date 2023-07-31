package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.model.product.AttrGroup;
import com.lsh.ssyx.vo.product.AttrGroupQueryVo;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【attr_group(属性分组)】的数据库操作Service
* @createDate 2023-07-31 16:56:44
*/
public interface AttrGroupService extends IService<AttrGroup> {

    /**
     * 平台属性分组列表
     * @param pageParam
     * @param attrGroupQueryVo
     * @return
     */
    IPage<AttrGroup> selectPageAttrGroup(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo);

    /**
     * 查询所有平台属性分组列表
     * @return
     */
    List<AttrGroup> findAllListAttrGroup();
}

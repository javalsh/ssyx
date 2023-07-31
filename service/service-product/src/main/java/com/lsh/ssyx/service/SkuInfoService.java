package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.ssyx.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.vo.product.SkuInfoQueryVo;
import com.lsh.ssyx.vo.product.SkuInfoVo;

/**
* @author liushaohua
* @description 针对表【sku_info(sku信息)】的数据库操作Service
* @createDate 2023-07-31 16:56:44
*/
public interface SkuInfoService extends IService<SkuInfo> {

    /**
     * sku列表
     * @param pageParam
     * @param skuInfoQueryVo
     * @return
     */
    IPage<SkuInfo> selectPageSkuInfo(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo);

    /**
     * 添加商品sku信息
     * @param skuInfoVo
     */
    void saveSkuInfo(SkuInfoVo skuInfoVo);

    /**
     * 获取sku信息
     * @param id
     * @return
     */
    SkuInfoVo getSkuInfo(Long id);

    /**
     * 修改sku
     * @param skuInfoVo
     */
    void updateSkuInfo(SkuInfoVo skuInfoVo);

    /**
     * 商品审核
     * @param skuId
     * @param status
     */
    void check(Long skuId, Integer status);

    /**
     * 商品上下架
     * @param skuId
     * @param status
     */
    void publish(Long skuId, Integer status);

    /**
     * 新人专享
     * @param skuId
     * @param status
     */
    void isNewPerson(Long skuId, Integer status);
}

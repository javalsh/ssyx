package com.lsh.ssyx.service;

import com.lsh.ssyx.model.product.SkuImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【sku_image(商品图片)】的数据库操作Service
* @createDate 2023-07-31 16:56:44
*/
public interface SkuImageService extends IService<SkuImage> {

    /**
     * 根据id查询商品图片列表
     * @param id
     * @return
     */
    List<SkuImage> getImageListBySkuId(Long id);
}

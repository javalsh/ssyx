package com.lsh.ssyx.service;

import com.lsh.ssyx.model.product.SkuPoster;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【sku_poster(商品海报表)】的数据库操作Service
* @createDate 2023-07-31 16:56:44
*/
public interface SkuPosterService extends IService<SkuPoster> {

    /**
     * 根据id查询商品海报列表
     * @param id
     * @return
     */
    List<SkuPoster> getPosterListBySkuId(Long id);
}

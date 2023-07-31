package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.SkuImage;
import com.lsh.ssyx.service.SkuImageService;
import com.lsh.ssyx.mapper.SkuImageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【sku_image(商品图片)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class SkuImageServiceImpl extends ServiceImpl<SkuImageMapper, SkuImage>
    implements SkuImageService{

    @Override
    public List<SkuImage> getImageListBySkuId(Long id) {
        LambdaQueryWrapper<SkuImage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SkuImage::getSkuId,id);
        return baseMapper.selectList(wrapper);
    }
}





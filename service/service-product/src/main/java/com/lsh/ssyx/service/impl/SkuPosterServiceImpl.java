package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.SkuPoster;
import com.lsh.ssyx.service.SkuPosterService;
import com.lsh.ssyx.mapper.SkuPosterMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【sku_poster(商品海报表)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class SkuPosterServiceImpl extends ServiceImpl<SkuPosterMapper, SkuPoster>
    implements SkuPosterService{

    @Override
    public List<SkuPoster> getPosterListBySkuId(Long id) {
        LambdaQueryWrapper<SkuPoster> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SkuPoster::getSkuId,id);
        return baseMapper.selectList(wrapper);
    }
}





package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.product.SkuAttrValue;
import com.lsh.ssyx.model.product.SkuImage;
import com.lsh.ssyx.model.product.SkuInfo;
import com.lsh.ssyx.model.product.SkuPoster;
import com.lsh.ssyx.service.SkuAttrValueService;
import com.lsh.ssyx.service.SkuImageService;
import com.lsh.ssyx.service.SkuInfoService;
import com.lsh.ssyx.mapper.SkuInfoMapper;
import com.lsh.ssyx.service.SkuPosterService;
import com.lsh.ssyx.vo.product.SkuInfoQueryVo;
import com.lsh.ssyx.vo.product.SkuInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【sku_info(sku信息)】的数据库操作Service实现
* @createDate 2023-07-31 16:56:44
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{

    @Autowired
    private SkuPosterService skuPosterService;

    @Autowired
    private SkuImageService skuImageService;

    @Autowired
    private SkuAttrValueService skuAttrValueService;
    
    @Override
    public IPage<SkuInfo> selectPageSkuInfo(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo) {
        String keyword = skuInfoQueryVo.getKeyword();
        Long categoryId = skuInfoQueryVo.getCategoryId();
        String skuType = skuInfoQueryVo.getSkuType();

        LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(keyword)) {
            wrapper.like(SkuInfo::getSkuName,keyword);
        }
        if(!StringUtils.isEmpty(categoryId)) {
            wrapper.eq(SkuInfo::getCategoryId,categoryId);
        }
        if(!StringUtils.isEmpty(skuType)) {
            wrapper.like(SkuInfo::getSkuType,skuType);
        }
        return baseMapper.selectPage(pageParam,wrapper);
    }

    @Override
    public void saveSkuInfo(SkuInfoVo skuInfoVo) {
        //1 添加sku基本信息
        // SkuInfoVo 复制-- SkuInfo
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(skuInfoVo,skuInfo);
        baseMapper.insert(skuInfo);

        //2 保存sku海报
        List<SkuPoster> skuPosterList = skuInfoVo.getSkuPosterList();
        if(!CollectionUtils.isEmpty(skuPosterList)) {
            //遍历，向每个海报对象添加商品skuId
            for (SkuPoster skuPoster:skuPosterList) {
                skuPoster.setSkuId(skuInfo.getId());
            }
            skuPosterService.saveBatch(skuPosterList);
        }

        //3 保存sku图片
        List<SkuImage> skuImagesList = skuInfoVo.getSkuImagesList();
        if(!CollectionUtils.isEmpty(skuImagesList)) {
            for (SkuImage skuImage:skuImagesList) {
                //设置商品skuId
                skuImage.setSkuId(skuInfo.getId());
            }
            skuImageService.saveBatch(skuImagesList);
        }

        //4 保存sku平台属性
        List<SkuAttrValue> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
        if(!CollectionUtils.isEmpty(skuAttrValueList)) {
            for (SkuAttrValue skuAttrValue:skuAttrValueList) {
                //设置商品skuId
                skuAttrValue.setSkuId(skuInfo.getId());
            }
            skuAttrValueService.saveBatch(skuAttrValueList);
        }
    }

    @Override
    public SkuInfoVo getSkuInfo(Long id) {
        SkuInfoVo skuInfoVo = new SkuInfoVo();

        //根据id查询sku基本信息
        SkuInfo skuInfo = baseMapper.selectById(id);

        //根据id查询商品图片列表
        List<SkuImage> skuImageList = skuImageService.getImageListBySkuId(id);

        //根据id查询商品海报列表
        List<SkuPoster> skuPosterList = skuPosterService.getPosterListBySkuId(id);

        //根据id查询商品属性信息列表
        List<SkuAttrValue> skuAttrValueList = skuAttrValueService.getAttrValueListBySkuId(id);

        //封装所有数据，返回
        BeanUtils.copyProperties(skuInfo,skuInfoVo);
        skuInfoVo.setSkuImagesList(skuImageList);
        skuInfoVo.setSkuPosterList(skuPosterList);
        skuInfoVo.setSkuAttrValueList(skuAttrValueList);
        return skuInfoVo;
    }

    @Override
    public void updateSkuInfo(SkuInfoVo skuInfoVo) {
        //修改sku基本信息
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(skuInfoVo,skuInfo);
        baseMapper.updateById(skuInfo);

        Long skuId = skuInfoVo.getId();
        //海报信息
        LambdaQueryWrapper<SkuPoster> wrapperSkuPoster = new LambdaQueryWrapper<>();
        wrapperSkuPoster.eq(SkuPoster::getSkuId,skuId);
        skuPosterService.remove(wrapperSkuPoster);

        List<SkuPoster> skuPosterList = skuInfoVo.getSkuPosterList();
        if(!CollectionUtils.isEmpty(skuPosterList)) {
            //遍历，向每个海报对象添加商品skuId
            for (SkuPoster skuPoster:skuPosterList) {
                skuPoster.setSkuId(skuId);
            }
            skuPosterService.saveBatch(skuPosterList);
        }

        //商品图片
        skuImageService.remove(new LambdaQueryWrapper<SkuImage>().eq(SkuImage::getSkuId,skuId));
        List<SkuImage> skuImagesList = skuInfoVo.getSkuImagesList();
        if(!CollectionUtils.isEmpty(skuImagesList)) {
            for (SkuImage skuImage:skuImagesList) {
                //设置商品skuId
                skuImage.setSkuId(skuId);
            }
            skuImageService.saveBatch(skuImagesList);
        }

        //商品属性
        skuAttrValueService.remove(new LambdaQueryWrapper<SkuAttrValue>().eq(SkuAttrValue::getSkuId,skuId));
        List<SkuAttrValue> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
        if(!CollectionUtils.isEmpty(skuAttrValueList)) {
            for (SkuAttrValue skuAttrValue:skuAttrValueList) {
                //设置商品skuId
                skuAttrValue.setSkuId(skuId);
            }
            skuAttrValueService.saveBatch(skuAttrValueList);
        }
    }

    @Override
    public void check(Long skuId, Integer status) {
        SkuInfo skuInfo = baseMapper.selectById(skuId);
        skuInfo.setCheckStatus(status);
        baseMapper.updateById(skuInfo);
    }

    @Override
    public void publish(Long skuId, Integer status) {

    }

    @Override
    public void isNewPerson(Long skuId, Integer status) {
        SkuInfo skuInfoUp = new SkuInfo();
        skuInfoUp.setId(skuId);
        skuInfoUp.setIsNewPerson(status);
        baseMapper.updateById(skuInfoUp);
    }
}





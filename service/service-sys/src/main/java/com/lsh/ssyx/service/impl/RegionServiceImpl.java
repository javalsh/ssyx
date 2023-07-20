package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.sys.Region;
import com.lsh.ssyx.service.RegionService;
import com.lsh.ssyx.mapper.RegionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【region(地区表)】的数据库操作Service实现
* @createDate 2023-07-20 16:30:49
*/
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region>
    implements RegionService{

    @Override
    public List<Region> findRegionByKeyword(String keyword) {
        LambdaQueryWrapper<Region> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Region::getName, keyword);
        return baseMapper.selectList(queryWrapper);
    }
}





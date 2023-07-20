package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.model.sys.Region;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【region(地区表)】的数据库操作Service
* @createDate 2023-07-20 16:30:49
*/
public interface RegionService extends IService<Region> {

    /**
     * 根据关键字获取地区列表
     * @param keyword
     * @return
     */
    List<Region> findRegionByKeyword(String keyword);
}

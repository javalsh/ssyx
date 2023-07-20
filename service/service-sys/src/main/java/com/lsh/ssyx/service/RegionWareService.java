package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.model.sys.RegionWare;
import com.lsh.ssyx.vo.sys.RegionWareQueryVo;

/**
* @author liushaohua
* @description 针对表【region_ware(城市仓库关联表)】的数据库操作Service
* @createDate 2023-07-20 16:30:49
*/
public interface RegionWareService extends IService<RegionWare> {

    /**
     * 开通区域列表
     * @param pageParam
     * @param regionWareQueryVo
     * @return
     */
    IPage<RegionWare> selectPage(Page<RegionWare> pageParam, RegionWareQueryVo regionWareQueryVo);

    /**
     * 添加开通区域
     * @param regionWare
     */
    void saveRegionWare(RegionWare regionWare);

    /**
     * 取消开通区域
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);
}

package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.model.acl.Admin;
import com.lsh.ssyx.vo.acl.AdminQueryVo;

/**
* @author liushaohua
* @description 针对表【admin(用户表)】的数据库操作Service
* @createDate 2023-07-06 14:52:54
*/
public interface AdminService extends IService<Admin> {

    /**
     * 用户分页列表
     * @param pageParam
     * @param userQueryVo
     * @return
     */
    IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo);
}

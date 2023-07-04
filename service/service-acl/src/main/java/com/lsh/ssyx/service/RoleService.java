package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.model.acl.Role;
import com.lsh.ssyx.vo.acl.RoleQueryVo;

/**
* @author liushaohua
* @description 针对表【role(角色)】的数据库操作Service
* @createDate 2023-07-04 17:17:54
*/
public interface RoleService extends IService<Role> {

    /**
     * 角色分页列表
     * @param pageParam
     * @param roleQueryVo
     * @return
     */
    IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo);
}

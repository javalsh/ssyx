package com.lsh.ssyx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsh.ssyx.model.acl.Permission;

import java.util.List;

/**
* @author liushaohua
* @description 针对表【permission(权限)】的数据库操作Service
* @createDate 2023-07-20 15:54:55
*/
public interface PermissionService extends IService<Permission> {

    /**
     * 获取所有菜单列表
     * @return
     */
    List<Permission> queryAllMenu();

    /**
     * 递归删除
     * @param id
     * @return 返回结果
     */
    boolean removeChildById(Long id);
}

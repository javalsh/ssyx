package com.lsh.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.ssyx.model.acl.Admin;
import com.lsh.ssyx.service.AdminService;
import com.lsh.ssyx.mapper.AdminMapper;
import com.lsh.ssyx.service.RoleService;
import com.lsh.ssyx.vo.acl.AdminQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
* @author liushaohua
* @description 针对表【admin(用户表)】的数据库操作Service实现
* @createDate 2023-07-06 14:52:54
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{

    @Override
    public IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo) {
        //获取用户名称条件值
        String name = userQueryVo.getName();
        String username = userQueryVo.getUsername();
        //创建条件构造器
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            //封装条件
            wrapper.like(Admin::getName, name);
        }
        if (!StringUtils.isEmpty(username)) {
            wrapper.like(Admin::getUsername, username);
        }
        //调用mapper方法
        return baseMapper.selectPage(pageParam, wrapper);
    }
}





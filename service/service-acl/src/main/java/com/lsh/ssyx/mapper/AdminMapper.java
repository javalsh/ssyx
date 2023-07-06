package com.lsh.ssyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsh.ssyx.model.acl.Admin;
import org.springframework.stereotype.Repository;

/**
* @author liushaohua
* @description 针对表【admin(用户表)】的数据库操作Mapper
* @createDate 2023-07-06 14:52:54
* @Entity com.lsh.ssyx.domain.Admin
*/
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

}





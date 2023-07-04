package com.lsh.ssyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsh.ssyx.model.acl.Role;
import org.springframework.stereotype.Repository;

/**
* @author liushaohua
* @description 针对表【role(角色)】的数据库操作Mapper
* @createDate 2023-07-04 17:17:54
* @Entity com.lsh.ssyx.model.acl.Role
*/
@Repository
public interface RoleMapper extends BaseMapper<Role> {

}





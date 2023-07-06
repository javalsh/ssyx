package com.lsh.ssyx.model.acl;

import com.lsh.ssyx.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shaohua.liu
 * Create at 2023/7/4
 */
@Data
@ApiModel(description = "用户")
@TableName("admin")
public class Admin extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户名")
	@TableField("username")
	private String username;

	@ApiModelProperty(value = "密码")
	@TableField("password")
	private String password;

	@ApiModelProperty(value = "昵称")
	@TableField("name")
	private String name;

	@ApiModelProperty(value = "手机")
	@TableField("phone")
	private String phone;

	@ApiModelProperty(value = "仓库id")
	@TableField("ware_id")
	private Long wareId;

	@ApiModelProperty(value = "角色名称")
	@TableField(exist = false)
	private String roleName;
}



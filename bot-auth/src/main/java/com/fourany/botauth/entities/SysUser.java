package com.fourany.botauth.entities;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月27日 15:40
 */
@Data
public class SysUser {
    private String id;
    @NotBlank(message="用户名不能为空")
    private String username;
    private String name;
    @NotBlank(message = "密码不能为空")
    private String password;

    private String telephone;

    private String avatar;

    private String creatorId;

    private Date create_time;

    private Integer status;

    private Integer deleted;

    private String lastLoginIp;


    private Date lastLoginTime;

    private Date expireTime;

    private String merchantCode;

    private String orgId;

}

package com.fourany.botauth.services;

import com.fourany.botauth.entities.SysUserRole;

import java.util.List;

public interface SysUserRoleService {
    List<SysUserRole> querySysUserRoleByUserId(String userid);

    //一个用户只能有一个角色
    SysUserRole getSysUserRoleByUserId(String userid);
}

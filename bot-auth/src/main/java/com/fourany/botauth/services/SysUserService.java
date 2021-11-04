package com.fourany.botauth.services;

import com.fourany.botauth.entities.SysUser;

import java.util.List;

public interface SysUserService {
    int addUser(SysUser sysUser);
    List<SysUser> querySysUserByUsername(String username);

    SysUser getSysUserByUsername(String username);

}

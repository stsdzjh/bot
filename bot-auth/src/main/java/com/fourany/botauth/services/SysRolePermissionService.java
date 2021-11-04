package com.fourany.botauth.services;

import com.fourany.botauth.entities.SysRolePermission;

import java.util.List;

public interface SysRolePermissionService {
    List<SysRolePermission> querySysRolePermissionByRoleId(String roleId);
}

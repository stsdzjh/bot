package com.fourany.botauth.services;

import com.fourany.botauth.entities.SysRoleFunction;

import java.util.List;

public interface SysRoleFunctionService {
    public List<SysRoleFunction> getSysRoleFunctionByRoleId(String roleId);
}

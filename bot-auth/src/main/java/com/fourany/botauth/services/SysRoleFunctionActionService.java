package com.fourany.botauth.services;

import com.fourany.botauth.entities.SysRoleFunctionAction;

import java.util.List;

public interface SysRoleFunctionActionService {
    List<SysRoleFunctionAction> querySysRoleFunctionActionByRoleFunctionId(String roleFunctionId);
}

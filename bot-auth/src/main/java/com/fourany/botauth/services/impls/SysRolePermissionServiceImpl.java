package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysRolePermission;
import com.fourany.botauth.mappers.SysRolePermissionMapper;
import com.fourany.botauth.services.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月17日 10:16
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysRolePermission> querySysRolePermissionByRoleId(String roleId) {
        return sysRolePermissionMapper.querySysRolePermissionByRoleId(roleId);
    }
}

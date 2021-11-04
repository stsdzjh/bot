package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysPermission;
import com.fourany.botauth.mappers.SysPermissionMapper;
import com.fourany.botauth.services.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月17日 10:15
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public SysPermission getPermissionById(String id) {
        return sysPermissionMapper.getPermissionById(id);
    }
}

package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysUserRole;
import com.fourany.botauth.mappers.SysUserRoleMapper;
import com.fourany.botauth.services.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 10:58
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysUserRole> querySysUserRoleByUserId(String userid) {
        return sysUserRoleMapper.querySysUserRoleByUserId(userid);
    }

    @Override
    public SysUserRole getSysUserRoleByUserId(String userid) {
        return sysUserRoleMapper.getSysUserRoleByUserId(userid);
    }
}

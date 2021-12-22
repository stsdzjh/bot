package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysRole;
import com.fourany.botauth.mappers.SysRoleMapper;
import com.fourany.botauth.services.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 14:27
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRole getSysRoleById(String id) {
        return sysRoleMapper.getSysRoleById(id);
    }


}

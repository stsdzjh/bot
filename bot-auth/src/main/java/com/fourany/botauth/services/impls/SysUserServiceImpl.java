package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysUser;
import com.fourany.botauth.mappers.SysUserMapper;
import com.fourany.botauth.services.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月27日 16:13
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public int addUser(SysUser sysUser) {
        return sysUserMapper.addUser(sysUser);
    }

    @Override
    public List<SysUser> querySysUserByUsername(String username) {
        return sysUserMapper.querySysUserByUsername(username);
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        return sysUserMapper.getSysUserByUsername(username);
    }
}

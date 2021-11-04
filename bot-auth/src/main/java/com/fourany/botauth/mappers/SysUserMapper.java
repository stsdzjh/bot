package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserMapper {

    int addUser(SysUser sysUser);

    @Select("select * from sys_users where username=#{username}")
    List<SysUser> querySysUserByUsername(String username);

    @Select("select * from sys_users where username=#{username}")
    SysUser getSysUserByUsername(String username);
}

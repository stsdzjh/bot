package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface SysRoleMapper {
    @Select("select * from sys_roles where id=#{id}")
    public SysRole getSysRoleById(String id);
}

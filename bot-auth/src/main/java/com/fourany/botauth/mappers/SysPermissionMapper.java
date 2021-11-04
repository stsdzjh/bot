package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysPermissionMapper {
    @Select("select * from sys_permissions where id=#{id}")
    public SysPermission getPermissionById(String id);
}

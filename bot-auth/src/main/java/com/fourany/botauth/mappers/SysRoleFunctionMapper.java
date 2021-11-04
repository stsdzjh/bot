package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysRoleFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleFunctionMapper {
    @Select("select * from sys_role_function where roleid=#{roleId}")
    public List<SysRoleFunction> getSysRoleFunctionByRoleId(String roleId);
}

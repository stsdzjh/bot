package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysRoleFunctionAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleFunctionActionMapper {
    @Select("select * from sys_role_function_action where role_function_id=#{roleFunctionId}")
    public List<SysRoleFunctionAction> querySysRoleFunctionActionByRoleFunctionId(String roleFunctionId);
}

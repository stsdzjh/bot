package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysFunctionMapper {
    @Select("select * from sys_functions where id=#{id}")
    public SysFunction getSysFunctionById(String id);
}

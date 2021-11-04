package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysActionMapper {
    @Select("select * from sys_actions where id=#{id}")
    public SysAction getSysActionById(String id);
}

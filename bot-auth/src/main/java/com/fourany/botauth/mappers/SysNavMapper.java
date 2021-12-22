package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysNav;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysNavMapper {
    @Select("select * from sys_navs order by `display_order` asc")
    public List<SysNav> queryAll();
}

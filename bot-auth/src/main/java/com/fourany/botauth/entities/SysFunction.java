package com.fourany.botauth.entities;

import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 10:19
 */
@Data
public class SysFunction {
    private String id;
    private String name;
    private String title;
    private String type;
    private String url;
    private String component;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
    private Integer status;
    private Integer deleted;
    private String parentId;

}

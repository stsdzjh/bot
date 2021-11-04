package com.fourany.botauth.entities;

import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月09日 17:29
 */
@Data
public class SysRole {
    private String id;
    private String name;
    private String describe;
    private Integer status;
    private String creatorId;
    private Date createTime;
    private Integer deleted;
    private String orgCode;


}

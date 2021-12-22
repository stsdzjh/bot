package com.fourany.botauth.entities;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月15日 16:34
 */
@Data
public class SysNav {
    private String id;
    private String path;
    private String component;
    private String redirect;
    private Boolean alwaysShow;
    private String name;
    private String title;
    private String icon;
    private String parentId;
    private String displayOrder;

}

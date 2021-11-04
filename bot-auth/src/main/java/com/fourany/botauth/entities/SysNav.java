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
    private String name;
    private String parentId;
    private String path;
    private String redirect;
    private String component;
    private String title;
    private String icon;
    private Boolean hiddenHeaderContent;
    private Boolean hideHeader;
    private Boolean hideChildren;
    private Boolean show;
    private String target;

}

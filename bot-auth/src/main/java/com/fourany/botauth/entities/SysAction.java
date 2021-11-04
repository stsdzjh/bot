package com.fourany.botauth.entities;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 10:10
 */
@Data
public class SysAction {
    private String id;
    private String code;
    private String title;
    private Integer defaultCheck;
    private Integer defaultDisplay;

}

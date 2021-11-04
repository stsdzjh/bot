package com.fourany.botauth.entities;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 10:25
 */
@Data
public class SysRoleFunctionAction {
    private String id;
    private String roleFunctionId;
    private String actionId;
    private Integer check;
    private Integer display;
}

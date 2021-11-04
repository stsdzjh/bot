package com.fourany.botauth.entities;

import lombok.Data;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月17日 10:12
 */
@Data
public class SysRolePermission {
    private String id;
    private String roleId;
    private String permissionId;

}

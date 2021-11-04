package com.fourany.botauth.entities;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月25日 23:48
 */
@Data
public class LoginRequest {
    @NotBlank(message="用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}

package com.fourany.common.enums;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月25日 22:34
 */


public enum ResultInfo {

    UNKNOWN_ERROR(30001,"未知错误"),

    TOKEN_SUCCESS(40000,"Token验证成功"),
    TOKEN_REQUIRED(40001,"需要请求携带Token"),
    TOKEN_INVALID(40002,"携带了无效的Token"),
    TOKEN_SIGNATURE_INVALID(40003,"Token签名错误"),
    TOKEN_EXPIRED(40004,"Token已过期"),

    DEFAULT_SUCCESS(20000,"调用成功"),
    DEFAULT_FAIL(50000,"调用失败"),

    /** 注册验证返回 **/
    REG_SUCCESS(61000,"用户注册成功"),
    REG_ERROR_USERNAME_EXISTS(61001,"用户名已存在"),
    REG_ERROR_PASSWORD_REQUIRED(61002,"必须提供注册密码"),

    /** 登录验证返回**/
    LOGIN_SUCCESS(60000,"登录成功"),
    LOGIN_ERROR_USERNAME_REQUIRED(60001,"用户名不能为空"),
    LOGIN_ERROR_PASSWORD_REQUIRED(60002,"密码不能为空"),
    LOGIN_ERROR_USER_NOT_EXISTS(60003,"用户不存在"),
    LOGIN_ERROR_USERNAME_OR_PWD_ERR(60004,"用户名或密码错误"),

    USER_NO_ROLE(70001, "用户尚未分配角色"),
    USER_NOT_EXISTIS(70002,"没有此用户"),
    USER_ROLE_NOT_EXISTS(70003,"用户所属角色不存在"),


    ;




    private Integer code;
    private String message;


    ResultInfo(Integer code, String message){
        this.code  = code;
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}

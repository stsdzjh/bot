package com.fourany.common.entities;

import com.fourany.common.enums.ResultInfo;
import lombok.Data;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月24日 17:39
 */
@Data
public class R {
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Integer code;
    private String message;
    private Object data;

    public R(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static R success(Object data){
        return new R(ResultInfo.DEFAULT_SUCCESS.getCode(), ResultInfo.DEFAULT_SUCCESS.getMessage(), data);
    }

    public static R success(String message, Object data){
        return new R(ResultInfo.DEFAULT_SUCCESS.getCode(),message,data);
    }

    public static R success(String message){
        return new R(ResultInfo.DEFAULT_SUCCESS.getCode(), message,null);
    }

    public static R fail(Integer code, String message, Object data){
        return new R(code,message,data);
    }

    public static R fail(Integer code, String message){
        return new R(code,message,null);
    }

    public static R fail(String message){
        return new R(ResultInfo.DEFAULT_FAIL.getCode(), message,null);
    }

    public static R fail(ResultInfo resultInfo,Object data){
        return new R(resultInfo.getCode(),resultInfo.getMessage(),data);
    }

    public static R result(Integer code, String message, Object data){
        return new R(code,message,data);
    }

    public static R result(ResultInfo resultInfo,Object data){
        return new R(resultInfo.getCode(),resultInfo.getMessage(),data);
    }



}

package com.fourany.common.exceptions;

import com.fourany.common.enums.ResultInfo;
import lombok.Data;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月30日 11:52
 */
@Data
public class TokenAuthException extends RuntimeException {
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

    private Integer code;
    private String message;

    public TokenAuthException(ResultInfo resultInfo){
        super(resultInfo.getMessage());
        this.code = resultInfo.getCode();
        this.message=resultInfo.getMessage();
    }
}

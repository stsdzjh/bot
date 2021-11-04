package com.fourany.common.exceptions;

import com.fourany.common.entities.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月30日 11:56
 */
@ControllerAdvice
public class TokenAuthExceptionHandler {
    @ExceptionHandler(TokenAuthException.class)
    @ResponseBody
    public R response(TokenAuthException tokenAuthException){
        return R.result(tokenAuthException.getCode(),tokenAuthException.getMessage(),null);
    }
}

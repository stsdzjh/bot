package com.fourany.botgateway.filter;

import cn.hutool.json.JSONUtil;

import com.fourany.common.entities.R;
import com.fourany.common.enums.ResultInfo;
import com.fourany.common.exceptions.TokenAuthException;
import com.fourany.common.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月29日 16:20
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {


    @Value("${gateway.tokenVarName}")
    private String tokenVarName;

    @Value("${auth.secretkey}")
    private String secretKey;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response =  exchange.getResponse();
        String requestURI = request.getURI().getPath();
        System.out.println(requestURI);
        /**检查白名单**/
        if(requestURI.indexOf("/auth/logout") >= 0 || requestURI.indexOf("/auth/login") >= 0 || requestURI.indexOf("/auth/reg") >= 0){
            return chain.filter(exchange);
        }
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(tokenVarName);
        System.out.println(token);
        if(StringUtils.isEmpty(token)){
            token = request.getQueryParams().getFirst(tokenVarName);
        }
        if(StringUtils.isEmpty(token)){
            R result = R.fail(ResultInfo.TOKEN_REQUIRED,null);
            DataBuffer buffer = response.bufferFactory().wrap(JSONUtil.parseObj(result).toString().getBytes());
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.writeWith(Flux.just(buffer));
        }
        try {
            JWTUtils.verifyToken(token, secretKey);
        }catch (TokenAuthException tokenAuthException){
            R result = R.fail(tokenAuthException.getCode(),tokenAuthException.getMessage(),null);
            DataBuffer buffer = response.bufferFactory().wrap(JSONUtil.parseObj(result).toString().getBytes());
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.writeWith(Flux.just(buffer));
        }


        String userName = JWTUtils.getUserInfo(token);
        ServerHttpRequest mutableReq = request.mutate().header("username", userName).build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(mutableExchange);
    }

    @Override
    public int getOrder() {
        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER + 1;
    }
}

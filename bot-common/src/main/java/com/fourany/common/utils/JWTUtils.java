package com.fourany.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.fourany.common.enums.ResultInfo;
import com.fourany.common.exceptions.TokenAuthException;

import java.util.Date;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月24日 11:28
 */
public class JWTUtils {
    public static final long TOKEN_EXPIRE_TIME = 7200 * 1000;
    public static final String ISSUER = "zhang";


    /**
    * @Description: 生成Token
    * @Param: [username, secretKey] 用户标识，不一定是用户名
    * @return: java.lang.String
    * @Author: zhangjh
    * @Date: 2021/9/24
    */
    public static String generateToken(String username, String secretKey){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Date now = new Date();
        Date dateExpireTime = new Date(now.getTime() + TOKEN_EXPIRE_TIME);

        String token = JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(now)
                .withExpiresAt(dateExpireTime)
                .withClaim("username",username)
                .sign(algorithm);

        return token;
    }

    public static void verifyToken(String token, String secretKey){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            jwtVerifier.verify(token);

        }catch (JWTDecodeException jwtDecodeException){
            throw new TokenAuthException(ResultInfo.TOKEN_INVALID);
        }catch (SignatureVerificationException signatureVerificationException){
            throw new TokenAuthException(ResultInfo.TOKEN_SIGNATURE_INVALID);
        }catch (TokenExpiredException tokenExpiredException){
            throw new TokenAuthException(ResultInfo.TOKEN_EXPIRED);
        }catch (Exception e){
            throw new TokenAuthException(ResultInfo.UNKNOWN_ERROR);
        }

    }

    public static String getUserInfo(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        String username = decodedJWT.getClaim("username").asString();
        return username;
    }
}

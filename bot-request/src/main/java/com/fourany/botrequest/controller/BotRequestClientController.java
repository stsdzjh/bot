package com.fourany.botrequest.controller;


import com.fourany.botrequest.client.BotRequestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月16日 14:49
 */

@RestController
@RequestMapping("/bot/request")
public class BotRequestClientController {
    @Autowired
    BotRequestClient botClient;


    @RequestMapping("/test")
    public String test(){

        //return clientBuilder.baseUrl(BASE_URL).build().get().uri("/bot/echo/"+"我是echo的内容").retrieve().bodyToMono(String.class);
        //throw new TokenAuthenticationException(11313,"aaaaaaaa");
        return botClient.test("我是测试的内容");
    }

}

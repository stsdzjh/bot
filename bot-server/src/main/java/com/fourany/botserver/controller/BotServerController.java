package com.fourany.botserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月15日 11:00
 */
@RestController
@RequestMapping("/bot/server")
public class BotServerController {
    @Value("${config.info}")
    private String info;

    @RequestMapping("/echo/{content}")
    public String test(@PathVariable String content){
        return "2-hello nacos: " + content;

    }

    @GetMapping("/config/info")
    public String getInfo(){
        return info;
    }
}

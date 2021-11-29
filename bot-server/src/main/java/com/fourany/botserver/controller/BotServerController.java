package com.fourany.botserver.controller;

import com.fourany.botserver.services.RasaService;
import com.fourany.botserver.services.impls.RasaServiceImpl;
import com.fourany.common.entities.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月15日 11:00
 */
@RestController
@RequestMapping("/bot/server")
public class BotServerController {

    @Autowired
    private RasaServiceImpl rasaService;

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

    @GetMapping("/health")
    public R getServerHealth(){
        return rasaService.getServerHealth();
    }

    @GetMapping("/version")
    public R getServerVersion(){
        return rasaService.getServerVersion();
    }

    @GetMapping("/status")
    public R getServerInfo(){
        return rasaService.getServerInfo();
    }


}

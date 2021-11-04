package com.fourany.botrequest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="bot-server")
@RequestMapping("/bot/server")
public interface BotRequestClient {
    @RequestMapping("/echo/{content}")
    String test(@PathVariable String content);
}

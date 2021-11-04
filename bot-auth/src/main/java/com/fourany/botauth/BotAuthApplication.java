package com.fourany.botauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableDiscoveryClient

public class BotAuthApplication
{
    public static void main( String[] args )
    {

        SpringApplication.run(BotAuthApplication.class,args);
    }
}

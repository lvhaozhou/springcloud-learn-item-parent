package com.lhz.learnitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: lhz
 * @Date: 2019/12/7 0007 15:52
 * @Description: member启动类
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AppMember {
    //@EnableEurekaClient将当前服务注册到eureka上
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }
}

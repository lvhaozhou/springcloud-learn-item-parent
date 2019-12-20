package com.lhz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: lhz
 * @Date: 2019/12/20 0020 14:00
 * @Description: springcloud 配置中心启动
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class AppConfigServer {
    //@EnableConfigServer 开启configServer
    //在git创建文件夹名称规范 服务名称-环境.properties
    public static void main(String[] args) {
        SpringApplication.run(AppConfigServer.class, args);
    }

}

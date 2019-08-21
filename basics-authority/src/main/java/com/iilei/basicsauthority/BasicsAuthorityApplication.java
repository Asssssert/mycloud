package com.iilei.basicsauthority;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan(value = "com.iilei.basicsauthority.mapper")
@SpringBootApplication
public class BasicsAuthorityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicsAuthorityApplication.class, args);
    }

}

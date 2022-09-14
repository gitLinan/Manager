package com.mobai.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * SpringBoot启动类
 *
 * @author li.nan
 * @date 2022/9/13
 */

@SpringBootApplication
@EnableFeignClients //开启FeignClient
@EnableDiscoveryClient //向Nacos注册该微服务
public class ManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

}

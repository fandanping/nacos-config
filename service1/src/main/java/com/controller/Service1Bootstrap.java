package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:    //http://localhost:56010/configs
 * @author: fandp
 * @create: 2020-02-25 15:21
 **/
@SpringBootApplication
@RestController
public class Service1Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Service1Bootstrap.class, args);
    }
    //通过value注解读取配置信息
 /*   @Value("${common.name}")
    private String config1;

    @GetMapping(value = "/configs")
    public String getConfigs(){
        return config1;
    }*/

    // 若要实现配置的动态更新，只需要进行如下改造：
    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @GetMapping(value = "/configs")
    public String getConfigs(){
        return applicationContext.getEnvironment().getProperty("common.name");
    }
}

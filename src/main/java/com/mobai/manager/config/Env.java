package com.mobai.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 环境变量配置
 *
 * @author li.nan
 * @date 2022/9/13
 */
@Component
public class Env {
    private static Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        Env.environment = environment;
    }

    public static String getProperty(String key){
        return environment.getProperty(key);
    }
}
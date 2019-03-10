package com.qzlydao.flas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-01 18:25
 */
@Configuration
public class ThreadConfig {

    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newFixedThreadPool(4);
    }

}

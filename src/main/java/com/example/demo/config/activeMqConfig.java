package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
@EnableJms//启动jms
public class activeMqConfig {
    //注入
    @Bean
    public Queue queue(){
        return  new ActiveMQQueue("study.msg.queue");
    }
}

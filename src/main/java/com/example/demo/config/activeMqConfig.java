package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms//启动jms
public class activeMqConfig {
    //注入队列
    @Bean
    public Queue queue(){
        return  new ActiveMQQueue("study.msg.queue");
    }
    //注入主题
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("study.msg.topic");
    }
   //  注意： 在pub/sub模式中，对消息的监听需要对containerFactory进行以下配置 topic 需要加入这个，否则无法启动到消息接受者
    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}

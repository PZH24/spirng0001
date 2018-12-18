package com.example.demo.service;

import com.example.demo.iml.MessageServiceImp;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;

@Service("Msg")
public class Msg implements MessageServiceImp {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;
    @Override
    public void sendMessage(String Msg) {
            this.jmsMessagingTemplate.convertAndSend(this.queue,Msg);
    }
    @JmsListener(destination = "study.msg.queue1")
    public  void getConsumeMsg(String text){
        System.out.println("接收端返回的信息："+text);
    }
}

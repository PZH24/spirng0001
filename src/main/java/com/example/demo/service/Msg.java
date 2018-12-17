package com.example.demo.service;

import com.example.demo.iml.MessgeServiceImp;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;

@Service
public class Msg implements MessgeServiceImp {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;
    @Override
    public void sendMessage(String Msg) {
            this.jmsMessagingTemplate.convertAndSend(this.queue,Msg);
    }
}

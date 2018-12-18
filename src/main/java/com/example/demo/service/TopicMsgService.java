package com.example.demo.service;

import com.example.demo.iml.MessageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

@Service("TopicMsgService")
public class TopicMsgService implements MessageServiceImp {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;
    @Override
    public void sendMessage(String Msg) {
            this.jmsMessagingTemplate.convertAndSend(this.topic,Msg);
    }
    @JmsListener(destination = "study.msg.topic2")
    public void  receiveMessage(String msg){
        System.out.println("接收消息topic2 :"+msg);
    }
}

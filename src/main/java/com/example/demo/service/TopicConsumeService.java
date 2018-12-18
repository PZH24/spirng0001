package com.example.demo.service;

import com.example.demo.iml.MessageConsumeServiceImp;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TopicConsumeService implements MessageConsumeServiceImp {

    @JmsListener(destination = "study.msg.topic" )
    public String receivesMessage(String Msg) {
        System.out.println("第二个接收消息topic1 :"+Msg);
        return "send Msg To topic2 :"+Msg;
    }
    @JmsListener(destination = "study.msg.topic")
    @SendTo("study.msg.topic2")
    @Override
    public String receiveMessage(String Msg) {
        System.out.println("第一个 接收消息topic1 :"+Msg);
        return "send Msg To topic2 :"+Msg;
    }
}

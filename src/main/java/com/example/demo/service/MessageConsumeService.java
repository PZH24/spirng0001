package com.example.demo.service;

import com.example.demo.iml.MessageConsumeServiceImp;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumeService implements MessageConsumeServiceImp {
    @JmsListener(destination = "study.msg.queue")
    @SendTo("study.msg.queue1")
    public  String receivesMessage(String text){
        System.out.println("[接受到的消息]"+text);
        return "study.msg.queue1"+text;
    }
    @JmsListener(destination = "study.msg.queue2")
    @Override
    public String receiveMessage(String text) {

        return "[接收信息]:"+text;
    }
}

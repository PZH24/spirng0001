package com.example.demo.service;

import org.springframework.jms.annotation.JmsListener;

public class MessageConsumeService {
    @JmsListener(destination = "study.msg.queue")
    public  void receiveMessage(String text){
        System.out.print("[接受到的消息]"+text);
    }
}

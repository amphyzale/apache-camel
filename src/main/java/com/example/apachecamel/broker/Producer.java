package com.example.apachecamel.broker;

import com.example.apachecamel.model.Info;
import com.example.apachecamel.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate template;

    public void sendMessage(String topic, Model message){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            template.convertAndSend(topic, message);
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
    }

    public void receiveMessage(String topic, Info message) {
        try{
            log.info("Attempting receive message to Topic: "+ topic);
            template.convertAndSend(topic, message);
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
    }
}

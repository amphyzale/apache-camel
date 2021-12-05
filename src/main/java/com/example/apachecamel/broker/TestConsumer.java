package com.example.apachecamel.broker;

import com.example.apachecamel.model.Info;
import com.example.apachecamel.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestConsumer {

    @JmsListener(destination = "default")
    public void receiveMessageFromDefault(@Payload Model model) {
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("received <" + model + "> from default");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");

    }

    @JmsListener(destination = "another")
    public void receiveMessageFromAnother(@Payload Info info) {
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("received <" + info + "> from another");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");

    }

}

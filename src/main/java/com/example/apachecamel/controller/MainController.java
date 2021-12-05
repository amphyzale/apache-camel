package com.example.apachecamel.controller;

import com.example.apachecamel.broker.Producer;
import com.example.apachecamel.model.Info;
import com.example.apachecamel.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final Producer producer;

    @PostMapping("/send/{topic}")
    public String sendMessage(@PathVariable String topic, @RequestBody Model model) {
        producer.sendMessage(topic, model);
        return "Message was sent to topic: " + topic;
    }

    @PostMapping("/receive/{topic}")
    public String receiveMessage(@PathVariable String topic, @RequestBody Info model) {
        producer.receiveMessage(topic, model);
        return "Message was sent to topic: " + topic;
    }
}

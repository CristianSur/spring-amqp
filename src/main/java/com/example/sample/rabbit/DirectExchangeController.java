package com.example.sample.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class DirectExchangeController {


    RabbitTemplate rabbitTemplate;
    RabbitExchangeProperty rabbitExchangeProperty;

    @GetMapping
    public String send() {
        rabbitTemplate.convertAndSend(
                rabbitExchangeProperty.exchange(),
                rabbitExchangeProperty.routingKey(),
                "test message"
        );
        return "ok. done";
    }

    @GetMapping("/direct")
    public String sendDirect() {
        rabbitTemplate.convertAndSend(rabbitExchangeProperty.queue(), "test message");
        return "ok. done";
    }

}

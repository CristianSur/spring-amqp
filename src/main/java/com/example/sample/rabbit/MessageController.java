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
public class MessageController {


    RabbitTemplate rabbitTemplate;
    BrokerProperty brokerProperty;

    @GetMapping("/exchange")
    public String sendThroughExchange() {
        rabbitTemplate.convertAndSend(
                brokerProperty.exchange(),
                brokerProperty.routingKey(),
                "some text message"
        );
        return "ok. done";
    }

    @GetMapping("/queue")
    public String sendDirectToQueue() {
        rabbitTemplate.convertAndSend(brokerProperty.queue(), "some text message");
        return "ok. done";
    }

}

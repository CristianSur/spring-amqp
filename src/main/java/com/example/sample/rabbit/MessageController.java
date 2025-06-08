package com.example.sample.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class MessageController {


    RabbitTemplate rabbitTemplate;
    BrokerProperty brokerProperty;

    @GetMapping("/exchange")
    public String sendThroughExchange(@RequestParam String message) {
        rabbitTemplate.convertAndSend(
                brokerProperty.exchange(),
                brokerProperty.routingKey(),
                message
        );
        return "ok. done";
    }

    @PostMapping("/exchange")
    public MessageObject sendThroughExchange(@RequestBody MessageObject messageObject) {
        rabbitTemplate.convertAndSend(
                brokerProperty.exchange(),
                brokerProperty.routingKey(),
                messageObject
        );
        return messageObject;
    }


//    @GetMapping("/queue")
//    public String sendDirectToQueue() {
//        rabbitTemplate.convertAndSend(brokerProperty.queue(), "some text message");
//        return "ok. done";
//    }

}

package com.example.sample.rabbit;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class QueueConsumer {

    @RabbitListener(queues = "${queue.name}")
    public void receiveMessage(@Payload String message) {
        log.info("Received <{}>", message);
    }
}

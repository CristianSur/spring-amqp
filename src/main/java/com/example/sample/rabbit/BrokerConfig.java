package com.example.sample.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BrokerConfig {

    BrokerProperty brokerProperty;


    //creates queue
    @Bean
    Queue queue() {
        return new Queue(brokerProperty.queue(), true);
    }

    //creates exchange
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(brokerProperty.exchange());
    }

    //binds created queue to exchange
    @Bean
    Binding bind(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(brokerProperty.routingKey());
    }

}

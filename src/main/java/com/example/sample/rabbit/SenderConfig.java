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
public class SenderConfig {

    RabbitExchangeProperty rabbitExchangeProperty;


    @Bean
    Queue queue() {
        return new Queue(rabbitExchangeProperty.queue(), true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(rabbitExchangeProperty.exchange());
    }

    @Bean
    Binding testeBinding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitExchangeProperty.routingKey());
    }

}

package com.example.sample.rabbit;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rabbit-config")
public record BrokerProperty(String queue, String exchange, String routingKey) {
}
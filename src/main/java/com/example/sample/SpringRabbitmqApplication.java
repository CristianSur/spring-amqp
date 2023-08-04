package com.example.sample;
import com.example.sample.rabbit.RabbitExchangeProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RabbitExchangeProperty.class)
public class SpringRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitmqApplication.class, args);
    }

}

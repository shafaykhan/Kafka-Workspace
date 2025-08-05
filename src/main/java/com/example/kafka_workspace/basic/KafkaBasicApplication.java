package com.example.kafka_workspace.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:kafka-basic-application.properties")
public class KafkaBasicApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaBasicApplication.class, args);
    System.out.println("Kafka Basic Application Started!");
  }
}

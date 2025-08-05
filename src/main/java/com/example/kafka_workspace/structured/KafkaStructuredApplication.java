package com.example.kafka_workspace.structured;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:kafka-structured-application.properties")
public class KafkaStructuredApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaStructuredApplication.class, args);
    System.out.println("Kafka Structured Application Started!");
  }
}

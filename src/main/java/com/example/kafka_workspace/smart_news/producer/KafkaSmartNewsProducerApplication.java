package com.example.kafka_workspace.smart_news.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaSmartNewsProducerApplication {

  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(KafkaSmartNewsProducerApplication.class);
    springApplication.setAdditionalProfiles("smart-news-producer");
    springApplication.run(args);
    System.out.println("Kafka Smart News Producer Application Started!");
  }
}

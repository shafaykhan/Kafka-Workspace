package com.example.kafka_workspace.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value("${spring.kafka.template.default-topic}")
  private String topicName;

  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    kafkaTemplate.send(topicName, message);
    System.out.println("Message sent: " + message);
  }
}

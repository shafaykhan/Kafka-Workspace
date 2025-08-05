package com.example.kafka_workspace.structured;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

  @Value("${spring.kafka.template.default-topic}")
  private String topicName;

  public KafkaProducer(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(KafkaMessage kafkaMessage) {
    kafkaTemplate.send(topicName, kafkaMessage);
    System.out.println("Message sent: " + kafkaMessage);
  }
}

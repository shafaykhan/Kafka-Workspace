package com.example.kafka_workspace.basic;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

  private final List<String> consumedMessageList = new ArrayList<>();

  @KafkaListener(topics = "my-topic-1", groupId = "my-group1")
  public void listenMessage1(String message) {
    consumedMessageList.addFirst(LocalDateTime.now() + " - GROUP 1 - " + message);
    System.out.println("Message received in GROUP1: " + message);
  }

  @KafkaListener(topics = "my-topic-1", groupId = "my-group2")
  public void listenMessage2(String message) {
    consumedMessageList.addFirst(LocalDateTime.now() + " - GROUP 2 - " + message);
    System.out.println("Message received in GROUP2: " + message);
  }

  public List<String> getConsumedMessages() {
    return consumedMessageList;
  }
}

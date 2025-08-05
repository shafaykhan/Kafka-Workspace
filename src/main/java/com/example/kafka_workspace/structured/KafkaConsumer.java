package com.example.kafka_workspace.structured;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

  private final List<KafkaMessage> consumedMessageList = new ArrayList<>();

  @KafkaListener(topics = "my-topic-2", groupId = "my-group")
  public void listenMessage1(KafkaMessage kafkaMessage) {
    kafkaMessage.setConsumer("CONSUMER 1");
    kafkaMessage.setDateTime(LocalDateTime.now());
    consumedMessageList.addFirst(kafkaMessage);
    System.out.println("Message received in CONSUMER 1 : " + kafkaMessage);
  }

  @KafkaListener(topics = "my-topic-2", groupId = "my-group")
  public void listenMessage2(KafkaMessage kafkaMessage) {
    kafkaMessage.setConsumer("CONSUMER 2");
    kafkaMessage.setDateTime(LocalDateTime.now());
    consumedMessageList.addFirst(kafkaMessage);
    System.out.println("Message received in CONSUMER 2 : " + kafkaMessage);
  }

  public List<KafkaMessage> getConsumedMessages() {
    return consumedMessageList;
  }
}

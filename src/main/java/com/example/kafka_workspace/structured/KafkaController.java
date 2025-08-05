package com.example.kafka_workspace.structured;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka/structured")
public class KafkaController {

  private final KafkaProducer kafkaProducer;
  private final KafkaConsumer kafkaConsumer;

  public KafkaController(KafkaProducer kafkaProducer,
                         KafkaConsumer kafkaConsumer) {
    this.kafkaProducer = kafkaProducer;
    this.kafkaConsumer = kafkaConsumer;
  }

  @GetMapping("/send")
  public ResponseEntity<String> sendMessage(@RequestParam String sender, @RequestParam String content) {
    kafkaProducer.sendMessage(KafkaMessage.builder()
        .sender(sender)
        .content(content)
        .build());
    return ResponseEntity.ok("Message sent successfully");
  }

  @GetMapping("/receive")
  public ResponseEntity<List<KafkaMessage>> getConsumedMessages() {
    return ResponseEntity.ok(kafkaConsumer.getConsumedMessages());
  }
}

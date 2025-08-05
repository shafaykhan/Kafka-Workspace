package com.example.kafka_workspace.structured;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessage {

  private String sender;
  private String content;

  private String consumer;
  private LocalDateTime dateTime;
}

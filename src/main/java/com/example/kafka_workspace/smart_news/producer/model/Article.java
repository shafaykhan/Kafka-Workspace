package com.example.kafka_workspace.smart_news.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

  private UUID id;
  private String title;
  private String content;
  private CategoryEnum category;
  private LocalDateTime publishTime;
}

package com.example.kafka_workspace.smart_news.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryEnum {

  TECH("tech_topic"),
  SPORTS("sports_topic"),
  POLITICS("politics_topic"),
  ENTERTAINMENT("entertainment_topic"),
  HEALTH("health_topic"),
  BUSINESS("business_topic"),
  SCIENCE("science_topic"),
  WORLD("world_topic");

  private final String topic;
}


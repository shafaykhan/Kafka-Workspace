package com.example.kafka_workspace.smart_news.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

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


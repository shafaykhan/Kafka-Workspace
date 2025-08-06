package com.example.kafka_workspace.smart_news.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private Long id;
  private String name;
  private List<CategoryEnum> subscribeArticleCategories;
  private Map<CategoryEnum, List<Article>> categoryAndArticlesMap = new HashMap<>();
}

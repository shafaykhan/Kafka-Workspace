package com.example.kafka_workspace.smart_news.consumer.service;

import com.example.kafka_workspace.smart_news.consumer.model.Article;
import com.example.kafka_workspace.smart_news.consumer.model.CategoryEnum;
import com.example.kafka_workspace.smart_news.consumer.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

  private final List<User> userList = List.of(
      User.builder()
          .id(1L).name("John").subscribeArticleCategories(Arrays.stream(CategoryEnum.values()).toList())
          .categoryAndArticlesMap(new HashMap<>())
          .build(),

      User.builder()
          .id(2L).name("Jane").subscribeArticleCategories(List.of(CategoryEnum.TECH, CategoryEnum.SPORTS))
          .categoryAndArticlesMap(new HashMap<>())
          .build(),

      User.builder()
          .id(3L).name("Doe").subscribeArticleCategories(List.of(CategoryEnum.TECH, CategoryEnum.POLITICS))
          .categoryAndArticlesMap(new HashMap<>())
          .build()
  );

  public User findById(Long id) {
    return userList.stream()
        .filter(user -> id.equals(user.getId()))
        .findFirst()
        .orElse(new User());
  }

  public void processArticleForSubscribedUsers(Article article) {
    userList.stream()
        .filter(user -> user.getSubscribeArticleCategories().contains(article.getCategory()))
        .forEach(user -> user.getCategoryAndArticlesMap()
            .computeIfAbsent(article.getCategory(), k -> new ArrayList<>())
            .add(article));
  }
}

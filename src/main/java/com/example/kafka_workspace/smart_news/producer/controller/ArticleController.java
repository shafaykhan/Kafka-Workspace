package com.example.kafka_workspace.smart_news.producer.controller;

import com.example.kafka_workspace.smart_news.producer.model.Article;
import com.example.kafka_workspace.smart_news.producer.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/smart-news/articles")
public class ArticleController {

  private final ArticleService service;

  public ArticleController(ArticleService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Article> save(@RequestBody Article article) {
    return ResponseEntity.ok(service.save(article));
  }
}

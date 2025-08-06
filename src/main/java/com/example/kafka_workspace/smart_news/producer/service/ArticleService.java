package com.example.kafka_workspace.smart_news.producer.service;

import com.example.kafka_workspace.smart_news.producer.kafka.ArticleProducer;
import com.example.kafka_workspace.smart_news.producer.model.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ArticleService {

  private final ArticleProducer producer;

  public ArticleService(ArticleProducer producer) {
    this.producer = producer;
  }

  public Article save(Article article) {
    article.setId(UUID.randomUUID());
    article.setPublishTime(LocalDateTime.now());

    producer.publishArticle(article);

    return article;
  }
}

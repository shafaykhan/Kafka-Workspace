package com.example.kafka_workspace.smart_news.consumer.kafka;

import com.example.kafka_workspace.smart_news.consumer.model.Article;
import com.example.kafka_workspace.smart_news.consumer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleConsumer {

  private final UserService userService;

  public ArticleConsumer(UserService userService) {
    this.userService = userService;
  }

  @KafkaListener(
      topics = {
          "tech_topic", "sports_topic", "politics_topic", "science_topic", "health_topic",
          "business_topic", "entertainment_topic", "world_topic"
      },
      groupId = "smart_news_group",
      containerFactory = "concurrentKafkaListenerContainerFactory"
  )
  public void consumeArticle(Article article, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
    userService.processArticleForSubscribedUsers(article);
    log.info("Received article on topic: {}, data : {}", topic, article);
  }
}

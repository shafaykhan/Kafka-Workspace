package com.example.kafka_workspace.smart_news.producer.kafka;

import com.example.kafka_workspace.smart_news.producer.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleProducer {

  private final KafkaTemplate<String, Article> kafkaTemplate;

  public ArticleProducer(KafkaTemplate<String, Article> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void publishArticle(Article article) {
    String topic = article.getCategory().getTopic();
    kafkaTemplate.send(topic, article);
    log.info("Message sent:: {}, {}", topic, article);
  }
}

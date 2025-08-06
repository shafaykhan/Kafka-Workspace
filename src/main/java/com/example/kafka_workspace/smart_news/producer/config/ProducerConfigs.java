package com.example.kafka_workspace.smart_news.producer.config;

import com.example.kafka_workspace.smart_news.producer.model.Article;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
public class ProducerConfigs {

  @Bean
  public ProducerFactory<String, Article> producerFactory() {
    Map<String, Object> producerConfigs = Map.of(
        org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
        org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
        org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
    );

    return new DefaultKafkaProducerFactory<>(producerConfigs);
  }

  @Bean
  public KafkaTemplate<String, Article> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}

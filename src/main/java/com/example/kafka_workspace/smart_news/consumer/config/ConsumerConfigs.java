package com.example.kafka_workspace.smart_news.consumer.config;

import com.example.kafka_workspace.smart_news.consumer.model.Article;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class ConsumerConfigs {

  @Bean
  public ConsumerFactory<String, Article> consumerFactory() {
    JsonDeserializer<Article> deserializer = new JsonDeserializer<>(Article.class);
    deserializer.addTrustedPackages("*");

    Map<String, Object> consumerConfigs = Map.of(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
        ConsumerConfig.GROUP_ID_CONFIG, "smart_news_group",
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class
    );

    return new DefaultKafkaConsumerFactory<>(consumerConfigs, new StringDeserializer(), deserializer);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Article> concurrentKafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Article> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }
}

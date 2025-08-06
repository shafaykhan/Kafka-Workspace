package com.example.kafka_workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		basePackages = "com.example.kafka_workspace",
		excludeFilters = {
				@ComponentScan.Filter(
						type = FilterType.REGEX,
						pattern = "com\\.example\\.kafka_workspace\\.basic\\..*"
				),
				@ComponentScan.Filter(
						type = FilterType.REGEX,
						pattern = "com\\.example\\.kafka_workspace\\.structured\\..*"
				),
				@ComponentScan.Filter(
						type = FilterType.REGEX,
						pattern = "com\\.example\\.kafka_workspace\\.smart_news\\..*"
				)
		}
)
public class KafkaWorkspaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaWorkspaceApplication.class, args);
	}

}

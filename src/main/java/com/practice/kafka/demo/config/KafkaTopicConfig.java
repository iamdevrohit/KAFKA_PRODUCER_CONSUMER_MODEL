package com.practice.kafka.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

   // https://stream.wikimedia.org/v2/stream/recentchange

    public final static String TOPIC ="KafkaTopicConfig";

    //start server
    //.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

    //.\bin\windows\kafka-server-start.bat .\config\server.properties

    //.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic KafkaTopicConfig --from-beginning


    @Bean
    public NewTopic newtopic(){
        return TopicBuilder.name("KafkaTopicConfig").build();
    }

    @Bean
    public NewTopic json_topic(){
        return TopicBuilder.name("KafkaTopicConfig").build();
    }
}

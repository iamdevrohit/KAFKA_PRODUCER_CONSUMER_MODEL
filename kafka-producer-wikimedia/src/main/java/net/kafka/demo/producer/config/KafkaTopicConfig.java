package net.kafka.demo.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

//    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
//    .\bin\windows\kafka-server-start.bat .\config\server.properties
//    .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic WikiMediaRecentChanges --from-beginning

    public final static String WIKIMEDIA_TOPIC ="WikiMediaRecentChanges";

    @Bean
    public NewTopic newtopic(){
        return TopicBuilder.name(WIKIMEDIA_TOPIC).build();
    }

}

package com.practice.kafka.demo.kafka.producer;

import com.practice.kafka.demo.config.KafkaTopicConfig;
import com.practice.kafka.demo.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user){
        LOGGER.info(String.format("Message send %s",user.toString()));
        Message<User> message = MessageBuilder.
                withPayload(user).
                setHeader(TOPIC, KafkaTopicConfig.TOPIC).build();

        kafkaTemplate.send(message);
    }
}

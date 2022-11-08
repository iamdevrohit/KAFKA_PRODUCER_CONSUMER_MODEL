package com.practice.kafka.demo.kafka.consumer;

import com.practice.kafka.demo.kafka.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import static com.practice.kafka.demo.config.KafkaTopicConfig.TOPIC;

@Service
public class KafkaConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void sendmsg(String data){
        kafkaTemplate.send(TOPIC,data);
    }


//    @KafkaListener(topics = TOPIC,groupId = "mygroup")
//    public void consumeData(String payload){
//
//        LOGGER.info(String.format("Message received -> %s",payload));
//
//
////        System.out.println("topic_name : "+payload.topic());
////        System.out.println("header : "+payload.headers());
////        System.out.println("partition : "+payload.partition());
////        System.out.println("value : "+payload.value());
//    }

}

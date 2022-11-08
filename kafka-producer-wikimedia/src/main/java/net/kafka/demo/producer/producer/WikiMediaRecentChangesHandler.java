package net.kafka.demo.producer.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import static net.kafka.demo.producer.config.KafkaTopicConfig.WIKIMEDIA_TOPIC;

@Service
public class WikiMediaRecentChangesHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaRecentChangesHandler.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    @Override
    public void onOpen() throws Exception {

    }


    @Override
    public void onClosed() throws Exception {

    }


    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
      LOGGER.info(String.format("event data  --->  "+messageEvent.getData()));
      kafkaTemplate.send(WIKIMEDIA_TOPIC,messageEvent.getData());
    }


    @Override
    public void onComment(String s) throws Exception {

    }


    @Override
    public void onError(Throwable throwable) {

    }
}

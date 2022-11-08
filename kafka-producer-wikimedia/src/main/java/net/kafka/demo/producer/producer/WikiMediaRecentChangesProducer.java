package net.kafka.demo.producer.producer;

import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikiMediaRecentChangesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaRecentChangesProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    WikiMediaRecentChangesHandler wikiMediaRecentChangesHandler;


    public void sendMessage() throws InterruptedException {

        //to use real data extream data we need to use event source
        String url ="https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource.Builder builder = new EventSource.Builder(wikiMediaRecentChangesHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);


    }

}

package net.kafkademo.consumer.consumer;

import net.kafkademo.consumer.entity.WikimediaRecentChange;
import net.kafkademo.consumer.repository.WikimediaRecentChangesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaDatabaseConsumer {

    public final static String WIKIMEDIA_TOPIC ="WikiMediaRecentChanges";
    public final static String WIKIMEDIA_GROUP ="myGroup";

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaDatabaseConsumer.class);

    @Autowired
    WikimediaRecentChangesRepository wikimediaRecentChangesRepository;


    @KafkaListener(topics = WIKIMEDIA_TOPIC,groupId = WIKIMEDIA_GROUP)
    public void consumeTopic(String msg){

        WikimediaRecentChange recentChange = new WikimediaRecentChange();
        recentChange.setWikiEventData(msg);

        wikimediaRecentChangesRepository.save(recentChange);


        LOGGER.info(String.format("message received  --->  "+msg));

    }

}

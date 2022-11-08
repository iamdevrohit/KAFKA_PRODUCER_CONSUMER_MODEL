package net.kafka.demo.producer;

import net.kafka.demo.producer.producer.WikiMediaRecentChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaProducerApplication implements CommandLineRunner {

	@Autowired
	WikiMediaRecentChangesProducer wikiMediaRecentChangesProducer;

	public static void main(String[] args) {
		SpringApplication.run(WikimediaProducerApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		wikiMediaRecentChangesProducer.sendMessage();
	}
}

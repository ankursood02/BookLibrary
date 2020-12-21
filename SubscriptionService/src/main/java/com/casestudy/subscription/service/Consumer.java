package com.casestudy.subscription.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.casestudy.subscription.repository.BookUserRepository;

@Service
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	/*
	 * @KafkaListener(topics = "Book_Topic", groupId = "group_1") public void
	 * consume(String message) {
	 * logger.info(String.format("$$ -> Consumed Message -> %s", message)); }
	 */
	@Autowired
	BookUserRepository bookUserRepository;

	@KafkaListener(topics = "Book_Topic", groupId = "group_1") 
	public void messageListner(ConsumerRecord<String, String> cr) throws Exception { 
		List<String> names=readMessage(cr.value());
		for (String name : names) {
			logger.info("------>Email message sent to : " + name + " [email address:"
					+ bookUserRepository.findById(name).get().getEmail() + "] that the book with bookId:" + cr.value()
					+ " is now available in Book Store!!! Go ahead to subscribe it!!!");
		}
	}

	public List<String> readMessage(String topic) {

		List<String> usernames = new ArrayList<>();
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:2182");
		props.put("group.id", topic);
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("max.poll.records", "10");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList(topic));
		ConsumerRecords<String, String> messages = consumer.poll(Duration.ofMillis(1000));

		for (ConsumerRecord<String, String> message : messages) {
			usernames.add(message.value());
		}
		consumer.close();
		return usernames;
	}
}

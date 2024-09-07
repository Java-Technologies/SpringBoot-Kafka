package com.interview;

import com.interview.dto.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class DemoconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoconsumerApplication.class, args);
	}


	@KafkaListener(topics = "interviewasset1", groupId = "payment_consumer_group")
	public void paymentConsumer1(PaymentRequest paymentRequest) throws JsonProcessingException {

		log.info("paymentConsumer1 consumed message {} ", new ObjectMapper().writeValueAsString(paymentRequest));

	}
}

package com.example.spring.consumeRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumeRestApplication {

	private final Logger logger=LoggerFactory.getLogger(ConsumeRestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumeRestApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate template) throws Exception {
		return args->{
			Quote quote=template.getForObject("http://localhost:8080/api/random", Quote.class);
			logger.info(quote.toString());
		};
	}
}

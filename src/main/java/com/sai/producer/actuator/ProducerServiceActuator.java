package com.sai.producer.actuator;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;

@Component
public class ProducerServiceActuator {

	@Bean
	@ServiceActivator(inputChannel = "outboundMsgChanel")
	public PubSubMessageHandler messageSender(PubSubTemplate pubsubtTemplate) {
		return new PubSubMessageHandler(pubsubtTemplate, "pubsubDemo");
	}

}

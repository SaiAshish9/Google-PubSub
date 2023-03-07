package com.sai.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.producer.gateway.OutboundChanel;

@Component
@RestController
public class ProducerRestController {
	
	@Autowired
	OutboundChanel gateway;
	
	@PostMapping("/publishMessage")
	public String publishMessage(@RequestBody String msg) {
		gateway.sendMsgToPubSub(msg);
		return "Message sent to PubSub successfully";
	}

}

package com.frans.demo;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
   
	private static Logger log = LoggerFactory.getLogger(ServiceController.class);
	
	@RequestMapping("/service/access")
	public String getAccessCode(){
		log.info("Server hit in this instance");
		Random random = new Random();
		return String.valueOf(random.nextLong());
	}
	
	@RequestMapping(value = "/")
	  public String home() {
	      return "Hi!";
	  }
}

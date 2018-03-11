package com.frans.boot.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.frans.boot.ribbon.config.RibbonServerConfiguration;



@Controller
@RibbonClient(name = "ribbon-server", configuration = RibbonServerConfiguration.class)
public class WebServiceController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/welcome")
	public String getPlayers(Model model) {
		String accessCode =  this.restTemplate.getForObject("http://ribbon-server/service/access", String.class);
		model.addAttribute("title", accessCode);
		return "welcome";
	}
}

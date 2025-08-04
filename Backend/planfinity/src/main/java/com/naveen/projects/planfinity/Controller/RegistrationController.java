package com.naveen.projects.planfinity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.naveen.projects.planfinity.Entities.Registration;
import com.naveen.projects.planfinity.Services.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService service;
	
	
	@PostMapping("/registerEvent")
	public Registration registerEvent(@RequestBody Registration registration) {
		return 
				
				service.registerEvent(registration);
		
	}
}

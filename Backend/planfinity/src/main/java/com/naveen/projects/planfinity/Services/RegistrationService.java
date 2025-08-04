package com.naveen.projects.planfinity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.projects.planfinity.Entities.Registration;
import com.naveen.projects.planfinity.Repository.RegistrationRepo;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepo repo;
	
	public Registration registerEvent(Registration registration) {
		return repo.save(registration);
	}

}

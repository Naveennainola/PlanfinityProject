package com.naveen.projects.planfinity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.projects.planfinity.Entities.Event;
import com.naveen.projects.planfinity.Entities.Registration;
import com.naveen.projects.planfinity.Entities.User;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {
	boolean existsByUserAndEvent(User user, Event event);
}

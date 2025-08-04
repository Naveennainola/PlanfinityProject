package com.naveen.projects.planfinity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.projects.planfinity.Entities.Event;

public interface PlanfinityRepo extends JpaRepository<Event, Integer>{
	
	

}

package com.naveen.projects.planfinity.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.projects.planfinity.Entities.Event;
import com.naveen.projects.planfinity.Entities.Registration;
import com.naveen.projects.planfinity.Entities.User;
import com.naveen.projects.planfinity.Repository.PlanfinityRepo;
import com.naveen.projects.planfinity.Repository.RegistrationRepo;
import com.naveen.projects.planfinity.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PlanfinityRepo eventrepo;
	
	@Autowired
	private RegistrationRepo registrationrepo;
	
	@PostMapping("/book")
    public ResponseEntity<String> bookEvent(@RequestBody Map<String, Integer> bookingData) {
        int userId = bookingData.get("userId");
        int eventId = bookingData.get("eventId");

        System.out.println(userId+" "+eventId);
        
        Optional<User> userOpt = userrepo.findById(userId);
        Optional<Event> eventOpt = eventrepo.findById(eventId);

        if (userOpt.isEmpty() || eventOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user or event");
        }

        User user = userOpt.get();
        Event event = eventOpt.get();

        if (registrationrepo.existsByUserAndEvent(user, event)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already registered for this event");
        }
        
        Registration registration = new Registration();
        registration.setUser(user);
        registration.setEvent(event);
        registrationrepo.save(registration);

        return ResponseEntity.ok("Event booked successfully");
    }
	
	

}

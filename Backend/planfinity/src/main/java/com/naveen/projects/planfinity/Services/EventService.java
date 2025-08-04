package com.naveen.projects.planfinity.Services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.projects.planfinity.Entities.Event;
import com.naveen.projects.planfinity.Entities.User;
import com.naveen.projects.planfinity.Repository.PlanfinityRepo;

import dtos.EventDTO;
import dtos.UserDTO;

@Service
public class EventService {
	
	@Autowired
    private PlanfinityRepo repo;
	
    public Event addEvent(Event event) throws IOException {

        return repo.save(event);
    }

    public EventDTO getEvent(int id) {
        Event data = repo.findById(id).orElse(new Event());
        EventDTO result = convertToDTO(data);
        return result;
    }

    public Event updateEvent(Event event) {
        return repo.save(event);
    }

    public void deleteEvent(int id) {
        repo.deleteById(id);
    }
    
    
    public List<EventDTO> getAllEventDTOs(){
    	List<Event> events = repo.findAll();  
    	return events.stream().map(this::convertToDTO).collect(Collectors.toList());    			
    }
    
    public EventDTO convertToDTO(Event event) {
    	EventDTO dto = new EventDTO();
    	
    	dto.setEventId(event.getEventId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setEventDate(event.getEventDate());
        dto.setLocation(event.getLocation());
        dto.setCapacity(event.getCapacity());
        dto.setCategory(event.getCategory());
        dto.setPrice(event.getPrice());
        // Convert image to Base64
        if (event.getImage() != null) {
            dto.setImageBase64(Base64.getEncoder().encodeToString(event.getImage()));
        }

        // Set Organizer
        User organizer = event.getOrganizer();
        if (organizer != null) {
            UserDTO organizerDTO = new UserDTO();
            organizerDTO.setUserId(organizer.getUser_id());
            organizerDTO.setName(organizer.getName());
            organizerDTO.setEmail(organizer.getEmail());
            organizerDTO.setRole(organizer.getRole());
            dto.setOrganizer(organizerDTO);
        }

        return dto;
    
    }
}

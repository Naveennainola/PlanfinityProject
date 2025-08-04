package com.naveen.projects.planfinity.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naveen.projects.planfinity.Entities.Event;
import com.naveen.projects.planfinity.Services.EventService;

import dtos.EventDTO;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class EventController {
	
	@Autowired
    private EventService service;
	
	
    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getAllEvents(){
        List<EventDTO> eventDTOs = service.getAllEventDTOs();
        return ResponseEntity.ok(eventDTOs);
    }

    
    @GetMapping("/eventinfo/{id}")
    public EventDTO getEventById(@PathVariable int id){

        EventDTO event = service.getEvent(id);
        return event;
    }

    

    @PostMapping(value = "/event", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Event addEvent(@RequestParam("event") String eventJson,
                          @RequestPart("image") MultipartFile image) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Event event = mapper.readValue(eventJson, Event.class);

        // Convert image and attach
        event.setImage(image.getBytes());

        return service.addEvent(event);  // or use your service method
    }






    @PutMapping("/event/{id}")
    public Event updateEvent(@RequestPart String eventJson,
                             @PathVariable int id,
                             @RequestPart MultipartFile image)throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        Event event = mapper.readValue(eventJson, Event.class);

        // Convert image and attach
        event.setImage(image.getBytes());

       return service.updateEvent(event);
    }

    @DeleteMapping("/event/{id}")
   public void deleteEventById(@PathVariable int id){
        service.deleteEvent(id);
   }

}

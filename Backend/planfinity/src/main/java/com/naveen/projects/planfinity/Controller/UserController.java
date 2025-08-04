package com.naveen.projects.planfinity.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.projects.planfinity.Entities.User;
import com.naveen.projects.planfinity.Services.UserService;

import dtos.LoginDTO;
import dtos.UserDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody UserDTO userDto) {
    	Map<String, String> response = new HashMap<>();
        try {
            userService.registerUser(userDto);
            response.put("message", "User registered successfully");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
        	response.put("message", e.getMessage()); // shows "Email already registered"
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception e) {
            response.put("message", "Registration failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        
    }

    @GetMapping("/user/{id}")
    public ResponseEntity < User >getUser(@PathVariable int id){
        User user = userService.getUser(id);
        if(user == null) return ResponseEntity.notFound().build();
        else
    	return     ResponseEntity.ok(user);
        }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
    	try {
    		UserDTO userDTO = userService.loginUser(loginDTO);
    		return ResponseEntity.ok(userDTO);
    	}
    	catch(RuntimeException e) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    		
    	}
    }

}

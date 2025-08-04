package com.naveen.projects.planfinity.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.naveen.projects.planfinity.Entities.User;
import com.naveen.projects.planfinity.Repository.UserRepository;

import dtos.LoginDTO;
import dtos.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userrepo;
	
	public User getUser(int id) {
		return userrepo.findById(id).orElse(new User());
	}
	
	public void registerUser(UserDTO user) {
		if (userrepo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists.");
        }
		User u = new User();
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setRole(user.getRole());
		userrepo.save(u);
	}
	
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}
	
	
	public UserDTO loginUser(LoginDTO loginDTO) {
		System.out.println("control in service");
		Optional<User> optionaluser = userrepo.findByEmail(loginDTO.getEmail());
		
		if(optionaluser.isEmpty()) {
			System.out.println("User not found");
			throw new RuntimeException("User not found");
		}
		
		User user = optionaluser.get();
		
		if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword()) || loginDTO.getClass().equals(user.getPassword())) {
			System.out.println("Invalid password");
			throw new RuntimeException("Invalid password");
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUser_id());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setRole(user.getRole());
		
		System.out.println(userDTO.getEmail());
		return userDTO;
		
	}

}

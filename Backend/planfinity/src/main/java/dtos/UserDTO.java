package dtos;

import org.springframework.context.annotation.Bean;

import com.naveen.projects.planfinity.Entities.User.Role;

public class UserDTO {
	
	private int userId;
	private String name;
	private String email;
	private String password;
	private Role role;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int userId, String name, String email, Role role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}

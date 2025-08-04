package com.naveen.projects.planfinity.Entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "User")
public class User {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.ATTENDEE;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public enum Role {
        ORGANIZER, ATTENDEE
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    public User(Date createdAt, String email, String name, String password, Role role, int user_id) {
        this.createdAt = createdAt;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.user_id = user_id;
    }
    public User(){}

    // Getters & Setters

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}


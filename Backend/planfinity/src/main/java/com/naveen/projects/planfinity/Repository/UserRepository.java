package com.naveen.projects.planfinity.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.projects.planfinity.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}

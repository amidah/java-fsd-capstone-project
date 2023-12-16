package com.capstone.project.foodbox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.project.foodbox.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	void deleteUserById(Long id);
	
	Optional<User> findUserById(Long id);
}

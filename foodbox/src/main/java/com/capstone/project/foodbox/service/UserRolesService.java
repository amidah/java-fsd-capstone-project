package com.capstone.project.foodbox.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.project.foodbox.model.UserRoles;
import com.capstone.project.foodbox.repository.UserRolesRepository;

@Service
@Transactional
public class UserRolesService {
	
	//Properties
	private final UserRolesRepository userRolesRepo;

	public UserRolesService(UserRolesRepository userRolesRepo) {		
		this.userRolesRepo = userRolesRepo;
	}

	public List<UserRoles> findAllUserRoles() {		
		return userRolesRepo.findAll();
	}	

}
package com.capstone.project.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.project.foodbox.model.Cuisine;

public interface CuisineRepository extends JpaRepository<Cuisine, Long>{

	void deleteCuisineById(Long id);
}

package com.capstone.project.foodbox.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.project.foodbox.model.Cuisine;
import com.capstone.project.foodbox.repository.CuisineRepository;

@Service
@Transactional
public class CuisineService {
	private final CuisineRepository cuisineRepository;

	@Autowired
	public CuisineService(CuisineRepository cuisineRepository) {
		super();
		this.cuisineRepository = cuisineRepository;
	}
	
	// CRUD Methods
	public List<Cuisine> findAlCuisines(){
		return cuisineRepository.findAll();
	}
	
	public Cuisine addCuisine(Cuisine cuisine) {
		return cuisineRepository.save(cuisine);
	}
	
	public Cuisine updateCuisine(Cuisine cuisine) {
		return cuisineRepository.save(cuisine);
	}
	
	public Cuisine updateCuisine(Cuisine cuisine, Long id) {
		if(cuisine.getId() == id) {
			return cuisineRepository.save(cuisine);
		}
		return null;
	}
	
	public void updateCuisineProductCount(Cuisine cuisine, int newProductCount) {
		cuisine.setProductCount(newProductCount);
	}
	
	public void deleteCuisine(Long id) {
		cuisineRepository.deleteCuisineById(id);
	}

	
}

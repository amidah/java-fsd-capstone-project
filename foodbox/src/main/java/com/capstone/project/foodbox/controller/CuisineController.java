package com.capstone.project.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.project.foodbox.model.Cuisine;
import com.capstone.project.foodbox.model.Product;
import com.capstone.project.foodbox.service.CuisineService;
import com.capstone.project.foodbox.service.ProductService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path="/cuisines")
public class CuisineController {

	private final CuisineService cuisineService;
	private final ProductService productService;
	
	@Autowired
	public CuisineController(CuisineService cusineService, ProductService productService) {
		super();
		this.cuisineService = cusineService;
		this.productService = productService;
	}
	
	// REST Endpoints
	public ResponseEntity<List<Cuisine>> getAllCuisines(){
		List<Cuisine> currentCuisines = cuisineService.findAllCuisines();
		List<Product> products = productService.findAllProducts();
		int cuisineCount=0, productCount=0;
		
		for(Cuisine c : currentCuisines) {
			System.out.println("Cuisine Id: " + c.getId() + ", Cuisine Name = " + c.getCuisineName());
			System.out.println("------------------------------------");
			
			if(c.getCuisineName().toLowerCase().equals("all")) {
				System.out.println("setting count of all products");
				productCount = products.size();
				cuisineService.updateCuisineProductCount(c, productCount);
			}
			else {
				for(Product p : products) {
					for(int i=0; i < p.getCuisines().length; i++) {
						if(p.cuisines[i].equals(c.getCuisineName())) {
							System.out.println("\tProduct " + p.getId() + " - " + p.getProductName());
							cuisineCount++;
						}
					}
				}
				cuisineService.updateCuisineProductCount(c, cuisineCount);
				cuisineCount=0;
			}
		}
		
		return new ResponseEntity<>(currentCuisines, HttpStatus.OK);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Cuisine> addCuisine(@RequestBody Cuisine cuisine){
		Cuisine newCuisine = cuisine;
		cuisineService.addCuisine(newCuisine);
		return new ResponseEntity<>(newCuisine, HttpStatus.CREATED);
	}
	
	/* Method to update Cuisine stored in the database */
	@PutMapping("/cuisine/update/{id}")
	public ResponseEntity<Cuisine> updateCuisineProductCount(@RequestBody Cuisine cuisine, @PathVariable("id") Long id){
		System.out.println("Cuisine Passed In:\n" + cuisine.toString());
		System.out.println("Id Passed In:" + id);
		Cuisine updatedCuisine = cuisineService.updateCuisine(cuisine);
		return new ResponseEntity<>(updatedCuisine, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/cuisine/delete/{id}")	
    public ResponseEntity<?> deleteTag(@PathVariable("id") Long id){
		cuisineService.deleteCuisine(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
}

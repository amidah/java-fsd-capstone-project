package com.capstone.project.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.project.foodbox.model.Tag;

public interface TagsRepository extends JpaRepository<Tag, Long>{
	
	void deleteTagById(Long id);

}

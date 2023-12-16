package com.capstone.project.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.project.foodbox.model.Tag;
import com.capstone.project.foodbox.repository.TagsRepository;

@Service
@Transactional
public class TagsService {
	
	//Properties
	private final TagsRepository tagsRepo;	
	
	//Constructor with Dependency Injection of the Tags Repository	
	@Autowired
	public TagsService(TagsRepository tagsRepo) {		
		this.tagsRepo = tagsRepo;
		
	}
	
	//CRUD Methods
	public List<Tag> findAllTags() {		
		return tagsRepo.findAll();
	}
	
	public Tag addTags(Tag tag) {
		return tagsRepo.save(tag);
	}	

	public void updateTagProductCount(Tag tag, int newProductCount) {		
		tag.setProductCount(newProductCount);		
	}

	public Tag updateTag(Tag tag) {
		return tagsRepo.save(tag);
	}
	
	public Tag updateTag(Tag tag, Long id) {		
		if(tag.getId() == id)
			return tagsRepo.save(tag);
		return null;
	}

	
	public void deleteTag(Long id) {
		tagsRepo.deleteTagById(id);		
	}

}

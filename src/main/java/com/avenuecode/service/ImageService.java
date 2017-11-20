package com.avenuecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenuecode.model.Image;
import com.avenuecode.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository repository;
	
	/**
	 * save a image
	 * @param image
	 * @return image
	 */
	public Image save(Image image) {
		return 	this.repository.save(image);
	}
	/**
	 * returns all images in database
	 * @return Iterable<Image>
	 */
	public List<Image> findAll(){
		return (List<Image>) this.repository.findAll();	}
	
	/**
	 * find a image throught id
	 * @param id
	 * @return
	 */
	public Image findById(long id) {
		return this.repository.findOne(id);
	}
	/**
	 * delete a image
	 * @param image
	 */
	public void delete(Image image) {
		this.repository.delete(image);
	}
}
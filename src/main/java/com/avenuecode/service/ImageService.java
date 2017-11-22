package com.avenuecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenuecode.model.Image;
import com.avenuecode.repository.ImageRepository;
import com.avenuecode.repository.ProductRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * save a image
	 * @param image
	 * @return image
	 */
	public Image save(Image image) {
		// check if product is valid 
		// yes I know I`ve to use hibernate validator... but my time is short now. :(
		if(image == null) {
			throw new IllegalArgumentException("image cannot be null");

		}
		//  if id product NOT exists
		if (! productRepository.exists(image.getProduct().getId())) {
			throw new IllegalArgumentException("Invalid product id");

		}
		return 	this.imageRepository.save(image);		
	}
	/**
	 * returns all images in database
	 * @return Iterable<Image>
	 */
	public List<Image> findAll(){
		return (List<Image>) this.imageRepository.findAll();	}
	
	/**
	 * find a image throught id
	 * @param id
	 * @return
	 */
	public Image findById(long id) {
		return this.imageRepository.findOne(id);
	}
	/**
	 * delete a image
	 * @param id
	 * @return boolean indicating if the image was deleted or not
	 * 
	 */
	public boolean delete(long id) {
		Image image = this.imageRepository.findOne(id);
		if (image != null) {			
			this.imageRepository.delete(image);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public List<Image> findImageByProductId(long productId){
		return this.imageRepository.findImageByProductId(productId);
	}
}
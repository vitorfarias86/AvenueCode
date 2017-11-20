package com.avenuecode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.avenuecode.model.Image;
import com.avenuecode.service.ImageService;

public class ImageController {
	
	@Autowired
	private ImageService service;

	@RequestMapping(value = "/image/", method = RequestMethod.GET)
	public ResponseEntity<List<Image>> listAllImages() {
		List<Image> images = service.findAll();
		if (images.isEmpty()) {
			return new ResponseEntity<List<Image>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Image>>(images, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public ResponseEntity<Image> getImage(@PathVariable("id") long id) {
		Image  image = service.findById(id);
        if (image == null) {
            return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
        }	
        return new ResponseEntity<Image>(image, HttpStatus.OK);
    }

	@RequestMapping(value = "/image/", method = RequestMethod.PUT)
    public ResponseEntity<Void> save(@RequestBody Image image, UriComponentsBuilder ucBuilder) {
		service.save(image);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/image/{id}").buildAndExpand(image.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
    @RequestMapping(value = "/image/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Image> deleteImage(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Image with id " + id);
 
        Image image = service.findById(id);
        if (image == null) {
            System.out.println("Unable to delete. Image with id " + id + " not found");
            return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
        }
        service.delete(image);
        return new ResponseEntity<Image>(HttpStatus.NO_CONTENT);
    }

}

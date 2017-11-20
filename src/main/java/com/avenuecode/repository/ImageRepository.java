package com.avenuecode.repository;

import org.springframework.data.repository.CrudRepository;

import com.avenuecode.model.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}

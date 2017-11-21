package com.avenuecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.avenuecode.model.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {
	@Query("from Image i WHERE i.product.id = ?1")
	public List<Image> findImageByProductId(long id);
}

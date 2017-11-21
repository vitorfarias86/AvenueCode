package com.avenuecode.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 5796855808295869588L;

	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "FATHER_ID")
	@JsonBackReference
	private Product father;
	
	@OneToMany(mappedBy="father", fetch=FetchType.LAZY)
	@JsonManagedReference
	private Set<Product> childProducts = new HashSet<>();
	
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private Set<Image> childImages = new HashSet<>();
	
	public Product() {
	}
	public Product(String l) {
		this.name = l;		
	}

	public Set<Product> getChildProducts() {
		return childProducts;
	}
	
	public void setChildProducts(Set<Product> childProducts) {
		this.childProducts = childProducts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Product getFather() {
		return father;
	}

	public void setFather(Product father) {
		this.father = father;	
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Image> getChildImages() {
		return childImages;
	}
	public void setChildImages(Set<Image> childImages) {
		this.childImages = childImages;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}

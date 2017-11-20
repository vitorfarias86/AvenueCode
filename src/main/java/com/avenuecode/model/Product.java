package com.avenuecode.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "FATHER_ID")
	private Product product;
	
	@OneToMany(mappedBy="product")
	private Set<Product> childProducts = new HashSet<>();
	
	@OneToMany(mappedBy="prod")
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
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;	
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
	@Override
	public String toString() {
		return String.format("Product [id=%s, name=%s, description=%s, product=%s, childProducts=%s, childImages=%s]",
				id, name, description, product, childProducts, childImages);
	}
}

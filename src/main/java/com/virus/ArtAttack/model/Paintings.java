package com.virus.ArtAttack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Paintings {

	@Id
	private String id;
	@NotNull
	@Size(min=2,max=20)
	private String name;
	@NotNull
	private String quantity;
	@NotNull
	private double price;
	@NotNull
	@Size(min=2,max=400)
	private String description;
	private String category_id;
	private String artist_id;
	@Transient
	MultipartFile paintingimage;
	public MultipartFile getPaintingimage() {
		return paintingimage;
	}
	public void setPaintingimage(MultipartFile paintingimage) {
		this.paintingimage = paintingimage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	
}

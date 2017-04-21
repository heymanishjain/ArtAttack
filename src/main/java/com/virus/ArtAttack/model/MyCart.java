package com.virus.ArtAttack.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
public class MyCart {

	@Id
	private long id;//Cart ID
	private String user_id;//User ID
	private String painting_id;
	private String paintingname;
	private Date dateadded;
	private String status;
	private double price;
	private int quantity;
	@Column(name="sumprice")
	private int sum;
	//No Need Of Total
	@Transient
	private int total;
	
	public String getPainting_id() {
		return painting_id;
	}
	public void setPainting_id(String painting_id) {
		this.painting_id = painting_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPaintingname() {
		return paintingname;
	}
	public void setPaintingname(String paintingname) {
		this.paintingname = paintingname;
	}
	public Date getDateadded() {
		return dateadded;
	}
	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}

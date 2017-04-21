package com.virus.ArtAttack.dao;

import java.util.List;

import com.virus.ArtAttack.model.Checkout;

public interface CheckoutDAO {

	public List<Checkout> showUserCheckout(String userid);
	
	public boolean saveUserCheckout(Checkout checkout);
	
	public boolean updateUserCheckout(Checkout checkout);
	
	public boolean deleteUserCheckout(Checkout checkout);
	
	public String checkoutEmptyOrNot(String id);
}

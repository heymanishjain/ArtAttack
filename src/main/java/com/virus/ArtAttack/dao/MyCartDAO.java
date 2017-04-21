package com.virus.ArtAttack.dao;

import java.util.List;

import com.virus.ArtAttack.model.MyCart;

public interface MyCartDAO {

	public List<MyCart> showUserCart(String id);
	
	public boolean saveUserCart(MyCart myCart);
	
	public boolean updateUserCart(MyCart myCart);
	
	public boolean deleteUserCart(MyCart myCart);
	
	public MyCart getUserCartById(long id);
	
	public MyCart getUserCartByName(String name);
	
	public int getProductSum(int price,int quantity);
	
}

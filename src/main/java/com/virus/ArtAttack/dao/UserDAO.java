package com.virus.ArtAttack.dao;

import com.virus.ArtAttack.model.User;

public interface UserDAO {

	public boolean saveUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public User getUserById(String id);
	
	public User getUserByName(String name);
	
	public User validateUserLogin(String id,String password);
}

package com.virus.ArtAttack.dao;

import java.util.List;

import com.virus.ArtAttack.model.Category;

public interface CategoryDAO {

	public List<Category> showAllCategory();
	
	public boolean saveCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
	public Category getCategoryById(String id);
	
	public Category getCategoryByName(String name);
}

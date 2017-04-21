package com.virus.ArtAttack.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.virus.ArtAttack.dao.CategoryDAO;
import com.virus.ArtAttack.model.Category;

@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<Category> showAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public boolean saveCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategoryById(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	public Category getCategoryByName(String name) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name='"+name+"'").uniqueResult();
	}

}

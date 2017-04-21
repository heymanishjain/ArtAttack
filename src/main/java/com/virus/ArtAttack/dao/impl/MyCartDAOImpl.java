package com.virus.ArtAttack.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.virus.ArtAttack.dao.MyCartDAO;
import com.virus.ArtAttack.model.MyCart;
import com.virus.ArtAttack.model.User;


@Repository("myCartDAO")
@EnableTransactionManagement
public class MyCartDAOImpl implements MyCartDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public MyCartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<MyCart> showUserCart(String id) {
		return sessionFactory.getCurrentSession().createQuery("from MyCart where user_id='"+id+"' and status='N'").list();
	}
	
	public boolean saveUserCart(MyCart myCart) {
		try 
		{
			sessionFactory.getCurrentSession().save(myCart);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUserCart(MyCart myCart) {
		try 
		{
			sessionFactory.getCurrentSession().update(myCart);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUserCart(MyCart myCart) {
		try 
		{
			sessionFactory.getCurrentSession().delete(myCart);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public MyCart getUserCartById(long id) {
		return (MyCart) sessionFactory.getCurrentSession().get(MyCart.class, id);
	}

	public MyCart getUserCartByName(String name) {
		return (MyCart) sessionFactory.getCurrentSession().createQuery("from MyCart where name='"+name+"'").uniqueResult();
	}
	
	//Cart Quantity * Product Price
	public int getProductSum(int price,int quantity) {
		return price*quantity;
	}
	public int getProductTotal(String id)
	{
		String hql = "select isnull(sum(sumprice),0) from MyCart where user_id='"+id+"' and status='N'";
		String result = sessionFactory.getCurrentSession().createSQLQuery(hql).uniqueResult().toString();
		int total = Integer.parseInt(result);
		return total;
	}
}
package com.virus.ArtAttack.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.virus.ArtAttack.dao.CheckoutDAO;
import com.virus.ArtAttack.model.Checkout;
import com.virus.ArtAttack.model.MyCart;

@Repository("checkoutDAO")
@EnableTransactionManagement
public class CheckoutDAOImpl implements CheckoutDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public CheckoutDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<MyCart> showUserCartAfterBill(String id) {
		return sessionFactory.getCurrentSession().createQuery("from MyCart where user_id='"+id+"' and status='O'").list();
	}
	
	public List<Checkout> showUserCheckout(String userid) {
		return sessionFactory.getCurrentSession().createQuery("from Checkout where user_id='"+userid+"'").list();
	}
	
	public String checkoutEmptyOrNot(String id)
	{
		return sessionFactory.getCurrentSession().createSQLQuery("select count(*) from Checkout where user_id='"+id+"'").uniqueResult().toString();
	}

	public boolean saveUserCheckout(Checkout checkout) {
		try 
		{
			sessionFactory.getCurrentSession().save(checkout);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUserCheckout(Checkout checkout) {
		try 
		{
			sessionFactory.getCurrentSession().update(checkout);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUserCheckout(Checkout checkout) {
		try 
		{
			sessionFactory.getCurrentSession().delete(checkout);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}


	public boolean changeCartStatus(String id) {
		try {
			sessionFactory.getCurrentSession().createSQLQuery("update MyCart set status='O' where user_id='"+id+"'").executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public int getProductTotal(String id)
	{
		String hql = "select isnull(sum(sumprice),0) from MyCart where user_id='"+id+"' and status='O'";
		String result = sessionFactory.getCurrentSession().createSQLQuery(hql).uniqueResult().toString();
		int total = Integer.parseInt(result);
		return total;
	}
}

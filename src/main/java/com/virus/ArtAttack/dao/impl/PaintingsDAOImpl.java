package com.virus.ArtAttack.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.virus.ArtAttack.dao.PaintingsDAO;
import com.virus.ArtAttack.model.Paintings;

@Repository("paintingsDAO")
@EnableTransactionManagement
public class PaintingsDAOImpl implements PaintingsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PaintingsDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<Paintings> showAllPaintings() {
		return sessionFactory.getCurrentSession().createQuery("from Paintings").list();
	}

	public boolean savePainting(Paintings paintings) {
		try 
		{
			sessionFactory.getCurrentSession().save(paintings);
			return true;
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updatePainting(Paintings paintings) {
		try 
		{
			sessionFactory.getCurrentSession().update(paintings);
			return true;
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletePainting(Paintings paintings) {
		try 
		{
			sessionFactory.getCurrentSession().delete(paintings);
			return true;
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public Paintings getPaintingById(String id) {
		return (Paintings) sessionFactory.getCurrentSession().get(Paintings.class, id);
	}

	public Paintings getPaintingByName(String name) {
		return (Paintings) sessionFactory.getCurrentSession().createQuery("from Paintings where name='"+name+"'").uniqueResult();
	}

}

package com.virus.ArtAttack.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.virus.ArtAttack.dao.ArtistDAO;
import com.virus.ArtAttack.model.Artist;

@Repository("artistDAO")
@EnableTransactionManagement
public class ArtistDAOImpl implements ArtistDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ArtistDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<Artist> showAllArtist() {
		return sessionFactory.getCurrentSession().createQuery("from Artist").list();
	}

	public boolean saveArtist(Artist artist) {
		try 
		{
			sessionFactory.getCurrentSession().save(artist);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateArtist(Artist artist) {
		try 
		{
			sessionFactory.getCurrentSession().update(artist);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteArtist(Artist artist) {
		try 
		{
			sessionFactory.getCurrentSession().delete(artist);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public Artist getArtistById(String id) {
		return (Artist) sessionFactory.getCurrentSession().get(Artist.class, id);
	}

	public Artist getArtistByName(String name) {
		return (Artist) sessionFactory.getCurrentSession().createQuery("from Artist where name='"+name+"'").uniqueResult();
	}
	
}

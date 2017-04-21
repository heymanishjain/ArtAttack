package com.virus.ArtAttack.dao;

import java.util.List;

import com.virus.ArtAttack.model.Artist;

public interface ArtistDAO {

	public List<Artist> showAllArtist();
	
	public boolean saveArtist(Artist artist);
	
	public boolean updateArtist(Artist artist);
	
	public boolean deleteArtist(Artist artist);
	
	public Artist getArtistById(String id);
	
	public Artist getArtistByName(String name);
}

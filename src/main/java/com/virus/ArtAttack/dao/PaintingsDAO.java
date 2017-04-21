package com.virus.ArtAttack.dao;

import java.util.List;

import com.virus.ArtAttack.model.Paintings;

public interface PaintingsDAO {

	public List<Paintings> showAllPaintings();
	
	public boolean savePainting(Paintings paintings);
	
	public boolean updatePainting(Paintings paintings);
	
	public boolean deletePainting(Paintings paintings);
	
	public Paintings getPaintingById(String id);
	
	public Paintings getPaintingByName(String name);
}

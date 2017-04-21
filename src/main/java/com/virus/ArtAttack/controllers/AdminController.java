package com.virus.ArtAttack.controllers;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virus.ArtAttack.dao.ArtistDAO;
import com.virus.ArtAttack.dao.CategoryDAO;
import com.virus.ArtAttack.dao.PaintingsDAO;
import com.virus.ArtAttack.dao.UserDAO;
import com.virus.ArtAttack.model.Artist;
import com.virus.ArtAttack.model.Category;
import com.virus.ArtAttack.model.Paintings;
import com.virus.ArtAttack.model.User;

@Controller
public class AdminController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	Paintings paintings;
	
	@Autowired
	PaintingsDAO paintingsDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private Category category;
	
	@Autowired
	private Artist artist;
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@RequestMapping("admin_manage_add_paintings")
	@Transactional
	public ModelAndView showAddPaintings()
	{
		ModelAndView mv = new ModelAndView("/Admin/AddPainting","command",new Paintings());
		mv.addObject("categoryList", categoryDAO.showAllCategory());
		mv.addObject("artistList", artistDAO.showAllArtist());
		return mv;
	}
	@Transactional
	@RequestMapping(value="admin_manage_edit_paintings",method=RequestMethod.GET)
	public ModelAndView showEditPaintings(@ModelAttribute Paintings paintings)
	{
		ModelAndView mv = new ModelAndView("/Admin/EditPainting","command",new Paintings());
		mv.addObject("categoryList", categoryDAO.showAllCategory());
		mv.addObject("artistList", artistDAO.showAllArtist());
		paintings = paintingsDAO.getPaintingById(paintings.getId());
		mv.addObject("id", paintings.getId());
		mv.addObject("name", paintings.getName());
		mv.addObject("qty", paintings.getQuantity());
		mv.addObject("price", paintings.getPrice());
		mv.addObject("desc", paintings.getDescription());
		category = categoryDAO.getCategoryById(paintings.getCategory_id());
		mv.addObject("categoryname", category.getName());
		artist = artistDAO.getArtistById(paintings.getArtist_id());
		mv.addObject("artistname", artist.getName());
		String path="D:\\NIIT Projects\\ArtAttack\\src\\main\\webapp\\images\\";
		mv.addObject("image", path);
		return mv;
	}
	@RequestMapping("admin_manage_add_categories")
	public ModelAndView showAddCategories()
	{
		ModelAndView mv = new ModelAndView("/Admin/AddCategory","command",new Category());
		return mv;
	}
	@Transactional
	@RequestMapping(value="admin_manage_edit_categories",method=RequestMethod.GET)
	public ModelAndView showEditPaintings(@ModelAttribute Category category)
	{
		ModelAndView mv = new ModelAndView("/Admin/EditCategory","command",new Category());
		category = categoryDAO.getCategoryById(category.getId());
		mv.addObject("id", category.getId());
		mv.addObject("name", category.getName());
		mv.addObject("desc", category.getDescription());
		return mv;
	}
	@RequestMapping("admin_manage_add_artist")
	public ModelAndView showAddArtist()
	{
		ModelAndView mv = new ModelAndView("/Admin/AddArtist","command",new Artist());
		return mv;
	}
	@Transactional
	@RequestMapping(value="admin_manage_edit_artist",method=RequestMethod.GET)
	public ModelAndView showEditArtist(@ModelAttribute Artist artist)
	{
		ModelAndView mv = new ModelAndView("/Admin/EditArtist","command",new Artist());
		artist = artistDAO.getArtistById(artist.getId());
		mv.addObject("id", artist.getId());
		mv.addObject("name", artist.getName());
		mv.addObject("desc", artist.getDescription());
		return mv;
	}
}

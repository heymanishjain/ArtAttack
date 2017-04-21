package com.virus.ArtAttack.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virus.ArtAttack.dao.ArtistDAO;
import com.virus.ArtAttack.model.Artist;

@Controller
public class ArtistController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private Artist artist;
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@Transactional
	@RequestMapping("/admin_manage_artist")
	public ModelAndView showArtist()
	{
		ModelAndView mv = new ModelAndView("/Artist/Artist");
		mv.addObject("displayArtist", artistDAO.showAllArtist());
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="admin_validate_add_artist",method=RequestMethod.POST)
	public ModelAndView validateAddArtist(@ModelAttribute Artist artist)
	{
		ModelAndView mv;
		mv=new ModelAndView("forward:/admin_manage_add_artist");
		mv.addObject("artist", artist);
		boolean b = true;
		if(artist.getId().equals(""))
		{
			mv.addObject("ID", "Please Enter Category ID");
			b=false;
		}
		if(artist.getDescription().equals(""))
		{
			mv.addObject("Description", "Please Enter Description");
			b=false;
		}
		if(artist.getName().equals(""))
		{
			mv.addObject("Name", "Please Enter Category Name");
			b=false;
		}
		if(b)
		{
			mv = new ModelAndView("forward:/admin_manage_artist");
			artistDAO.saveArtist(artist);
		}
		return mv;
	}
	@Transactional
	@RequestMapping(value="admin_validate_edit_artist",method=RequestMethod.POST)
	public ModelAndView validateEditArtist(@ModelAttribute Artist artist)
	{
		ModelAndView mv = new ModelAndView("forward:/admin_manage_artist");
		artistDAO.updateArtist(artist);
		return mv;
	}
	@Transactional
	@RequestMapping(value="/admin_manage_delete_artist",method=RequestMethod.GET)
	public ModelAndView deleteArtist(@RequestParam("id")String id)
	{
		ModelAndView mv = new ModelAndView("forward:/admin_manage_artist");
		artist=artistDAO.getArtistById(id);
		artistDAO.deleteArtist(artist);
		return mv;
	}
	
}

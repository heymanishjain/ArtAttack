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

import com.virus.ArtAttack.dao.CategoryDAO;
import com.virus.ArtAttack.model.Category;
import com.virus.ArtAttack.model.Paintings;

@Controller
public class CategoryController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private Category category;
	
	@Transactional
	@RequestMapping("/admin_manage_categories")
	public ModelAndView showCategories()
	{
		ModelAndView mv = new ModelAndView("/Category/Category");
		mv.addObject("displayCategories", categoryDAO.showAllCategory());
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/admin_validate_add_category",method=RequestMethod.POST)
	public ModelAndView validateAddCategories(@ModelAttribute Category category)
	{
		ModelAndView mv;
		mv = new ModelAndView("forward:/admin_manage_add_categories");
		mv.addObject("category", category);
		boolean b = true;
		if(category.getId().equals(""))
		{
			mv.addObject("ID", "Please Enter Category ID");
			b=false;
		}
		if(category.getDescription().equals(""))
		{
			mv.addObject("Description", "Please Enter Description");
			b=false;
		}
		if(category.getName().equals(""))
		{
			mv.addObject("Name", "Please Enter Category Name");
			b=false;
		}
		if(b)
		{
			mv = new ModelAndView("forward:/admin_manage_categories");
			categoryDAO.saveCategory(category);
		}
		return mv;
	}
	@Transactional
	@RequestMapping(value="/admin_validate_edit_category",method=RequestMethod.POST)
	public ModelAndView validateEditCategories(@ModelAttribute Category category)
	{
		ModelAndView mv = new ModelAndView("forward:/admin_manage_categories");
		categoryDAO.updateCategory(category);
		return mv;
	}
	@Transactional
	@RequestMapping(value="/admin_manage_delete_categories",method=RequestMethod.GET)
	public ModelAndView deleteCategories(@RequestParam("id")String id)
	{
		ModelAndView mv = new ModelAndView("forward:/admin_manage_categories");
		category=categoryDAO.getCategoryById(id);
		categoryDAO.deleteCategory(category);
		return mv;
	}
	
}

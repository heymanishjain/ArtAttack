package com.virus.ArtAttack.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virus.ArtAttack.dao.PaintingsDAO;
import com.virus.ArtAttack.dao.UserDAO;
import com.virus.ArtAttack.model.User;

@Controller
public class IndexController {

		@Autowired
		private HttpSession session;
		
		@Autowired
		private PaintingsDAO paintingsDAO;
		
		@Autowired
		private User user;
		
		@Autowired
		private UserDAO userDAO;
		
		@Transactional
		@RequestMapping("/")
		public ModelAndView showHome()
		{
			ModelAndView mv = new ModelAndView("/index");
			return mv;
		}
		@Transactional
		@RequestMapping("/home")
		public ModelAndView showHomePage()
		{
			ModelAndView mv = new ModelAndView("/index");
			return mv;
		}
		@RequestMapping("/about")
		public ModelAndView showAboutUsPage()
		{
			ModelAndView mv = new ModelAndView("/AboutUs");
			return mv;
		}
		@RequestMapping("/contact")
		public ModelAndView showContactUsPage()
		{
			ModelAndView mv = new ModelAndView("/ContactUs");
			return mv;
		}
		@Transactional
		@RequestMapping("/paintings")
		public ModelAndView showPaintings()
		{
			ModelAndView mv = new ModelAndView("/Items");
			mv.addObject("displayPaintings", paintingsDAO.showAllPaintings());
			return mv;
		}
		@RequestMapping("manage_login")
		public ModelAndView showLogin()
		{
			ModelAndView mv = new ModelAndView("/User/Login","command",new User());
			return mv;
		}
		@RequestMapping("manage_register")
		public ModelAndView showRegister()
		{
			ModelAndView mv = new ModelAndView("/User/Register","command",new User());
			return mv;
		}
		@Transactional
		@RequestMapping("manage_account_update")
		public ModelAndView showUserUpdate(@RequestParam("id")String id)
		{
			ModelAndView mv = new ModelAndView("/User/EditUser","command",new User());
			mv.addObject("user", userDAO.getUserById(id));
			return mv;
		}
}

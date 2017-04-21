package com.virus.ArtAttack.controllers;

import java.security.Principal;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virus.ArtAttack.dao.MyCartDAO;
import com.virus.ArtAttack.dao.UserDAO;
import com.virus.ArtAttack.model.MyCart;
import com.virus.ArtAttack.model.User;

@Controller
public class UserController {

	public static String logid;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private MyCart myCart;
	
	@Autowired
	private MyCartDAO cartDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/accessDenied")
	public ModelAndView validateAccessDenied()
	{
		ModelAndView mv = new ModelAndView("/AccessDenied");
		mv.addObject("msgAccessDenied", "You Are Not Authorised For This Task");
		return mv;
	}
	
	@RequestMapping(value="/validate_login_error",method = RequestMethod.GET)
	public ModelAndView validateLoginError()
	{
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("msg","Invalid User Credential");
		return mv;
	}
	
	@Transactional
	@RequestMapping("/validate_login")
	public ModelAndView validateLogin(HttpServletRequest request,@ModelAttribute User user,@RequestParam("id")String id,@RequestParam("password")String password)
	{
		user = userDAO.validateUserLogin(id, password);
		ModelAndView mv;
		if(user==null)
		{
			mv = new ModelAndView("/User/Login","command",new User());
			mv.addObject("wrongCredentials", "Please Check Whether Credentials Are Same");
			return mv;
		}
		else
		{
			String userid = SecurityContextHolder.getContext().getAuthentication().getName();
			user=userDAO.getUserById(userid);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
			String loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities(); 
			logid = loggedInUserid;
			if(user.getRole().equals("Role_Admin"))
			{
				session.setAttribute("showAdmin", "true");
			}
			mv = new ModelAndView("forward:/home","command",new User());
			session.setAttribute("userid", logid);
			session.setAttribute("userLogin", "true");
			session.setAttribute("userRegister", "true");
			return mv;
		}
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/validate_user")
	public ModelAndView validateUser(HttpSession session,Model model,HttpServletRequest request)
	{
		ModelAndView mv;
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		user=userDAO.getUserById(userid);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Principal principal = request.getUserPrincipal();
		String loggedInUserid = principal.getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities(); 
		logid = loggedInUserid;
		boolean b = request.isUserInRole("ROLE_ADMIN");
		boolean b1 = request.isUserInRole("ROLE_USER");
		if(user.getRole().equals("ROLE_ADMIN"))
		{
			session.setAttribute("showAdmin", "true");
			System.out.println(b);
		}
		mv = new ModelAndView("forward:/home","command",new User());
		System.out.println(b1);
		session.setAttribute("userid", logid);
		session.setAttribute("userLogin", "true");
		session.setAttribute("userRegister", "true");
		return mv;
	}

	@Transactional
	@RequestMapping("/validate_register")
	public ModelAndView validateRegister(@ModelAttribute User user,@RequestParam("password")String psw,@RequestParam("id") String uid,@RequestParam("firstname") String fname,@RequestParam("lastname")String lname,@RequestParam("email") String mail,@RequestParam("confirmpassword")String cpsw)
	{
		String compareEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		boolean b = mail.matches(compareEmail);
		String patternPSW = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		boolean b1 = psw.matches(patternPSW);
		boolean b2 = psw.equals(cpsw);
		boolean flag = true;
		ModelAndView mv;
		mv = new ModelAndView("/User/Register","command",new User());
		mv.addObject("user", user);
		mv.addObject("FNAME", fname);
		mv.addObject("LNAME", lname);
		if(uid=="")
		{
			mv.addObject("RUID","User Name Not Entered");
			flag=false;
		}
		if(psw=="")
		{
			mv.addObject("RPSW","Password Not Entered");
			flag=false;
		}
		if(cpsw=="")
		{
			mv.addObject("RCPSW","Confirm Password Not Entered");
			flag=false;
		}
		if(mail=="")
		{
			mv.addObject("RMAIL","Email Not Entered");
			flag=false;
		}
		if(fname=="")
		{
			mv.addObject("RFNAME","First Name Not Entered");
			flag=false;
		}
		if(lname=="")
		{
			mv.addObject("RLNAME","Last Name Not Entered");
			flag=false;
		}
		if(fname.equals(uid))
		{
			mv.addObject("compareUF", "First Name & User Name Must Not Be Same");
			flag=false;
		}
		if(b2!=true)
		{
			mv.addObject("compareP", "Password & Confirm Password Must Be Same");
			flag=false;
		}
		if(b1!=true)
		{
			mv.addObject("comparePSW", "Password Must Be Greater Than 8 Characters.It Should Conatin One Symbol One Capital Letter One Small Letter One Number and No Space");
			flag=false;
		}
		if(b!=true)
		{
			mv.addObject("compareE", "Email Is Not Properly Entered Make Sure (@) & (.) is used Example : example@abc.com");
			flag=false;
		}
		if(flag)
		{
			logid = uid;
			mv = new ModelAndView("/index","command",new User());
			user.setRole("Role_User");
			userDAO.saveUser(user);
			session.setAttribute("userid", logid);
			session.setAttribute("userRegister", "true");
			session.setAttribute("userLogin", "true");
		}
		return mv;
	}
	@Transactional
	@RequestMapping("/manage_account_settings")
	public ModelAndView showUserAccount()
	{
		ModelAndView mv = new ModelAndView("/User/User");
		String id = UserController.logid;
		user = userDAO.getUserById(id);
		mv.addObject("displayUser", user);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="validate_account_update",method=RequestMethod.POST)
	public ModelAndView validateUserUpdate(@ModelAttribute User user)
	{
		ModelAndView mv = new ModelAndView("forward:/manage_account_settings");
		userDAO.updateUser(user);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value = "manage_account_delete",method=RequestMethod.GET)
	public ModelAndView deleteUserAccount(@RequestParam("id")String id)
	{
		ModelAndView mv = new ModelAndView("forward:/manage_logout");
		user = userDAO.getUserById(id);
		userDAO.deleteUser(user);
		return mv;
	}
	
	@RequestMapping("/manage_logout")
	public ModelAndView Logout()
	{
		session.removeAttribute("userLogin");
		session.removeAttribute("userRegister");
		session.removeAttribute("showAdmin");
		session.removeAttribute("userid");
		session.invalidate();
		logid=null;
		ModelAndView mv = new ModelAndView("forward:/home");
		return mv;
	}
	
}

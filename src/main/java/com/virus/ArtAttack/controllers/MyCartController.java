package com.virus.ArtAttack.controllers;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virus.ArtAttack.dao.MyCartDAO;
import com.virus.ArtAttack.dao.PaintingsDAO;
import com.virus.ArtAttack.dao.impl.MyCartDAOImpl;
import com.virus.ArtAttack.model.Checkout;
import com.virus.ArtAttack.model.MyCart;
import com.virus.ArtAttack.model.Paintings;
import com.virus.ArtAttack.model.User;

@Controller
public class MyCartController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private MyCart myCart;
	
	@Autowired 
	private MyCartDAO myCartDAO;
	
	@Autowired
	private MyCartDAOImpl cartDAO;
	
	@Autowired
	private PaintingsDAO paintingsDAO;
	
	@Transactional
	@RequestMapping(value="/manage_cart",method=RequestMethod.GET)
	public ModelAndView showMyCart()
	{
		ModelAndView mv = new ModelAndView("/MyCart/MyCart");
		String id = UserController.logid;
		mv.addObject("displayMyCart", myCartDAO.showUserCart(id));
		int total = cartDAO.getProductTotal(id);
		mv.addObject("total", total);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/validate_cart_add_cart",method=RequestMethod.GET)
	public ModelAndView validateAddToCart(@RequestParam("pid")String paintingid,@ModelAttribute MyCart myCart)
	{
		ModelAndView mv;
		String id = UserController.logid;
		if(id==null)
		{
			mv = new ModelAndView("/User/Login","command",new User());
			return mv;
		}
		else
		{
			mv = new ModelAndView("forward:/manage_cart");
			long d = System.currentTimeMillis();
			Date today = new Date(d);
			Paintings paintings = paintingsDAO.getPaintingById(paintingid);
			myCart.setId(ThreadLocalRandom.current().nextInt(100,1000000+1));
			myCart.setStatus("N");
			myCart.setQuantity(1);
			myCart.setDateadded(today);
			myCart.setPainting_id(paintings.getId());
			myCart.setPaintingname(paintings.getName());
			myCart.setPrice(paintings.getPrice());
			myCart.setUser_id(id);
			myCart.setSum(myCartDAO.getProductSum((int) paintings.getPrice(),myCart.getQuantity()));
			myCartDAO.saveUserCart(myCart);
			return mv;
		}
	}
	
	@Transactional
	@RequestMapping(value="manage_cart_edit_cart_add_quantity",method=RequestMethod.GET)
	public ModelAndView validateEditCartAdd(@RequestParam("id")int id,@ModelAttribute MyCart myCart)
	{
		ModelAndView mv = new ModelAndView("forward:/manage_cart");
		myCart = myCartDAO.getUserCartById(id);
		int qty = myCart.getQuantity();
		qty++;
		myCart.setQuantity(qty);
		myCart.setSum(myCartDAO.getProductSum((int) myCart.getPrice(), qty));
		myCartDAO.updateUserCart(myCart);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="manage_cart_edit_cart_less_quantity",method=RequestMethod.GET)
	public ModelAndView validateEditCartLess(@RequestParam("id")int id,@ModelAttribute MyCart myCart)
	{
		ModelAndView mv = new ModelAndView("forward:/manage_cart");
		myCart = myCartDAO.getUserCartById(id);
		int qty = myCart.getQuantity();
		if(qty<=1)
		{
			myCart.setQuantity(qty);
		}
		else
		{
			qty--;
			myCart.setQuantity(qty);
		}
		myCart.setSum(myCartDAO.getProductSum((int) myCart.getPrice(), qty));
		myCartDAO.updateUserCart(myCart);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/manage_cart_delete_cart",method=RequestMethod.GET)
	public ModelAndView validateDeleteCart(@RequestParam("id")int id)
	{
		ModelAndView mv = new ModelAndView("forward:/manage_cart");
		myCart = myCartDAO.getUserCartById(id);
		myCartDAO.deleteUserCart(myCart);
		return mv;
	}
	
	@RequestMapping("manage_cart_add_checkout")
	public ModelAndView showAddCheckout()
	{
		ModelAndView mv = new ModelAndView("/Checkout/AddCheckout","command", new Checkout());
		return mv;
	}
}

package com.virus.ArtAttack.controllers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virus.ArtAttack.dao.CheckoutDAO;
import com.virus.ArtAttack.dao.MyCartDAO;
import com.virus.ArtAttack.dao.PaintingsDAO;
import com.virus.ArtAttack.dao.impl.CheckoutDAOImpl;
import com.virus.ArtAttack.dao.impl.MyCartDAOImpl;
import com.virus.ArtAttack.model.Checkout;
import com.virus.ArtAttack.model.MyCart;
import com.virus.ArtAttack.model.Paintings;

@Controller
public class CheckoutController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CheckoutDAO checkoutDAO;
	
	@Autowired
	private PaintingsDAO paintingDAO;
	
	@Autowired
	private Paintings paintings;
	
	@Autowired
	private MyCart myCart;
	
	@Autowired
	private MyCartDAOImpl cartDAO;
	
	@Autowired
	private MyCartDAO myCartDAO;
	
	@Autowired
	private CheckoutDAOImpl checkoutDAOImpl;
	
	@Transactional
	@RequestMapping("manage_cart_user_show_checkout")
	public ModelAndView displayUserCheckout()
	{
		ModelAndView mv = new ModelAndView("/Checkout/Checkout");
		String id = UserController.logid; 
		mv.addObject("displayCheckout", checkoutDAO.showUserCheckout(id));
		mv.addObject("displayMyCart", myCartDAO.showUserCart(id));
		int total = cartDAO.getProductTotal(id);
		mv.addObject("total", total);
		return mv;
	}
	
	@Transactional
	@RequestMapping("manage_cart_user_checkout")
	public ModelAndView checkUserCheckoutEmptyOrNot()
	{
		ModelAndView mv;
		String id = UserController.logid; 
		String result = checkoutDAO.checkoutEmptyOrNot(id);
		if(result=="0")
		{
			mv = new ModelAndView("forward:/manage_cart_add_checkout");
		}
		else
		{
			mv = new ModelAndView("forward:/manage_cart_user_show_checkout");
		}
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="validate_cart_user_checkout",method=RequestMethod.POST)
	public ModelAndView saveUserCheckout(@ModelAttribute Checkout checkout)
	{
		ModelAndView mv = new ModelAndView("forward:/manage_cart_user_show_checkout");
		String id = UserController.logid;
		checkout.setId(ThreadLocalRandom.current().nextInt(100,1000000+1));
		checkout.setUser_id(id);
		checkoutDAO.saveUserCheckout(checkout);
		return mv;
	}
	@Transactional
	@RequestMapping(value="manage_cart_generate_bill")
	public ModelAndView generateUserBill()
	{
		String id = UserController.logid;
		checkoutDAOImpl.changeCartStatus(id);
		ModelAndView mv = new ModelAndView("forward:/manage_cart_show_generated_bill");
		return mv;
	}
	@Transactional
	@RequestMapping(value="manage_cart_show_generated_bill")
	public ModelAndView showUserBill()
	{
		ModelAndView mv = new ModelAndView("/Checkout/GeneratedBill");
		String id = UserController.logid;
		mv.addObject("checkoutBill", checkoutDAO.showUserCheckout(id));
		mv.addObject("cartDetails", checkoutDAOImpl.showUserCartAfterBill(id));
		List<MyCart> list = checkoutDAOImpl.showUserCartAfterBill(id);
		int size = list.size();
		for(int i = 0;i<size;i++)
		{
			myCart = list.get(i);
			System.out.println(myCart.getPainting_id());
			String pid = myCart.getPainting_id();
			int cartqty = myCart.getQuantity();
			paintings = paintingDAO.getPaintingById(pid);
			String qty = paintings.getQuantity();
			int paintingqty = Integer.parseInt(qty);
			int newpaintingqty = paintingqty - cartqty;
			String newPaintingQty = String.valueOf(newpaintingqty);
			paintings.setQuantity(newPaintingQty);
		}
		int total = checkoutDAOImpl.getProductTotal(id);
		mv.addObject("total", total);
		return mv;
	}
	
}

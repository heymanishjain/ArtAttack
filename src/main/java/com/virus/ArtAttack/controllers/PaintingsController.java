package com.virus.ArtAttack.controllers;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.virus.ArtAttack.dao.ArtistDAO;
import com.virus.ArtAttack.dao.CategoryDAO;
import com.virus.ArtAttack.dao.PaintingsDAO;
import com.virus.ArtAttack.model.Artist;
import com.virus.ArtAttack.model.Category;
import com.virus.ArtAttack.model.Paintings;

@Controller
public class PaintingsController {
	
	@Autowired
	private Paintings paintings;
	
	@Autowired
	private PaintingsDAO paintingsDAO;
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Artist artist;
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@Transactional
	@RequestMapping("/admin_manage_paintings")
	public ModelAndView showPaintings()
	{
		ModelAndView mv = new ModelAndView("/Paintings/Painting");
		mv.addObject("displayPaintings", paintingsDAO.showAllPaintings());
		return mv;
	}
	@Transactional
	@RequestMapping(value="admin_validate_add_paintings",method=RequestMethod.POST)
	public ModelAndView validateAddPaintings(@ModelAttribute Paintings paintings)
	{
		ModelAndView mv;
		mv = new ModelAndView("forward:/admin_manage_add_paintings");
		MultipartFile filedet = paintings.getPaintingimage();
		mv.addObject("painting", paintings);
		boolean b = true;
		if(paintings.getId().equals(""))
		{
			 mv.addObject("ID", "Please Enter Painting ID");
			 b=false;
		}
		if(paintings.getName().equals(""))
		{
			mv.addObject("Name", "Please Enter Painting Name");
			b=false;
		}
		if(paintings.getQuantity().equals(""))
		{
			mv.addObject("Quantity", "Please Enter Quantity");
			b=false;
		}
		if(paintings.getDescription().equals(""))
		{
			mv.addObject("Description", "Please Enter Description");
			b=false;
		}
		if(paintings.getPrice()==0.0 && paintings.getPrice()==0)
		{
			mv.addObject("Price", "Please Enter Cost");
			b=false;
		}
		if(filedet.isEmpty())
		{
			mv.addObject("Image", "Please Upload An Image");
			b=false;
		}
		if(b)
		{
			mv = new ModelAndView("forward:/admin_manage_paintings");
			category = categoryDAO.getCategoryByName(paintings.getCategory_id());
			paintings.setCategory_id(category.getId());
			artist = artistDAO.getArtistByName(paintings.getArtist_id());
			paintings.setArtist_id(artist.getId());
			paintingsDAO.savePainting(paintings);
			String path="D:\\NIIT Projects\\ArtAttack\\src\\main\\webapp\\images\\";
			path=path+String.valueOf(paintings.getId())+".jpg";
			File f=new File(path);
			if(!filedet.isEmpty())
			{
				try
				{
				  byte[] bytes=filedet.getBytes();
				  System.out.println(bytes.length);
				  FileOutputStream fos=new FileOutputStream(f);
	              			BufferedOutputStream bs=new BufferedOutputStream(fos);
	              			bs.write(bytes);
	              			bs.close();
	             			 System.out.println("File Uploaded Successfully");
				}
				catch(Exception e)
				{
					System.out.println("Exception Arised"+e);
				}
			}
			else
			{
				System.out.println("File is Empty not Uploaded");
				
			}
		}
		return mv;
	}
	@Transactional
	@RequestMapping(value="admin_validate_edit_paintings",method=RequestMethod.POST)
	public ModelAndView validateEditPaintings(@ModelAttribute Paintings paintings)
	{
		ModelAndView mv = new ModelAndView("forward:/admin_manage_paintings");
		category = categoryDAO.getCategoryByName(paintings.getCategory_id());
		paintings.setCategory_id(category.getId());
		artist = artistDAO.getArtistByName(paintings.getArtist_id());
		paintings.setArtist_id(artist.getId());
		paintingsDAO.updatePainting(paintings);
		String path="D:\\NIIT Projects\\ArtAttack\\src\\main\\webapp\\images\\";
		path=path+String.valueOf(paintings.getId())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet = paintings.getPaintingimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		mv.addObject("painting", paintings);
		return mv;
	}
	@Transactional
	@RequestMapping(value="/admin_manage_delete_paintings",method=RequestMethod.GET)
	public ModelAndView deletePaintings(@RequestParam("id")String id)
	{
		ModelAndView mv = new ModelAndView("forward:/admin_manage_paintings");
		paintings=paintingsDAO.getPaintingById(id);
		paintingsDAO.deletePainting(paintings);
		return mv;
	}
}

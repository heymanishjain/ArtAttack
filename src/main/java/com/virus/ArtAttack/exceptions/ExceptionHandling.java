package com.virus.ArtAttack.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handleConstraintException(Exception e)
	{
		ModelAndView mv=new ModelAndView("/ExceptionsErrors");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
	}
	/*@ExceptionHandler(Exception.class)
	public ModelAndView handleAnyException(Exception e)
	{
		ModelAndView mv=new ModelAndView("/ExceptionsErrors");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
	}*/
}

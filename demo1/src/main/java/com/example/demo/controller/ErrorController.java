package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {

	@ExceptionHandler(Exception.class)   //to set Custom view for exception
	public ModelAndView handleError(HttpServletRequest request,Exception ex){
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",ex.getStackTrace());
		mav.addObject("url",request.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
	
	
}

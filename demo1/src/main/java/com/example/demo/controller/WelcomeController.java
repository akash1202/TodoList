package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	@Value("${spring.application.name}")
	private String name;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name",getLoggedInUserName(model));
		return "success";
	}
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal=SecurityContextHolder.getContext().
				getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();
		return principal.toString();
	}
	
//	 @RequestMapping(value="/login", method= RequestMethod.GET)
//	 public String init(Model model) {
//		 if(model.getAttribute("error")!=null) {
//		 model.addAttribute("message","Please Enter Your Login Details!!!");
//		 }
//		 return "login";
//	}
//	  
//	 
////	 @RequestMapping(value="/success",method=RequestMethod.GET)
////	 public String getSuccess(ModelMap model) {
////		// System.out.println((String)model.get("user"));
////		 return "success";
////	 }
//	 
//	 @RequestMapping(value="/home",method=RequestMethod.GET)
//	 public String getHome(ModelMap model) {
//		 return "home";
//	 }
//	 
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String submit(ModelMap model, @ModelAttribute("loginBean")LoginBean loginBean) {
//		if(loginBean!=null && loginBean.getUsername()!=null && loginBean.getPassword()!=null) {
//		if(loginService.validateUser(loginBean.getUsername(), loginBean.getPassword()))
//		{	model.put("name",loginBean.getUsername());
//			return "success";
//		}else {
//			model.put("error","Invalid Details");
//			return "login";
//		}
//		}else {
//			model.put("error","Please Enter Details");
//			return "login";
//		}
//	} 
	 
}

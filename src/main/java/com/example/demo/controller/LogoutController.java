package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
public class LogoutController {
	
	
	@Value("${spring.application.name}")
	private String name;
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutUser(HttpServletRequest request,HttpServletResponse response) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/";
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

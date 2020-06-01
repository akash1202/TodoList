package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Todo;
import com.example.demo.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

@Autowired
private TodoService service;

@InitBinder
public void initBinder(WebDataBinder binder) {
	// dd//MM/yyyy
	SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
	binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));  //wherever Date class will be retrieved in jsp page 
																					//this format will be applied
}

	
@RequestMapping(value="/list-todos",method=RequestMethod.GET)
public String showTodosPage(ModelMap model) {
		String name=(String) model.get("name");
		model.put("todos", service.retrieveTodos(name));
		model.put("todo", new Todo());
	 	return "todo";
}

@RequestMapping(value="/list-todos",method=RequestMethod.POST)
public String addTodo(ModelMap model,@Valid Todo todo,BindingResult result ) {
	if(result.hasErrors()) {
		return "todo";
	}else if(todo.getDesc()!=null) {	
	String name=(String) model.get("name");
		service.addTodo(name, todo.getDesc(),new Date(), false);
		model.put("todos", service.retrieveTodos(name));
	}
	 	return "todo";
}



@RequestMapping(value="/update-todo",method=RequestMethod.GET)
public String showUpdateTodo(ModelMap model,@RequestParam int id) {
	model.put("todo",service.retrieveTodo(id));
	return "todo";
}

@RequestMapping(value="/update-todo",method=RequestMethod.POST)
public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result ) {
	if(result.hasErrors()) {
		return "todo";
	}else if(todo.getDesc()!=null) {
		String name=(String) model.get("name");  //we just set id with hidden field not username of Todo  so need toset
		todo.setUser(name);
		service.updateTodo(todo);
		model.put("todos", service.retrieveTodos(name));
	}
	 	return "redirect:list-todos";
}

@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
public String removeTodo(@RequestParam int id) {
	if(id==1)
		throw new RuntimeException("something is not ok myfriend!!!");
	service.deleteTodo(id);
	return "redirect:list-todos";
}


}

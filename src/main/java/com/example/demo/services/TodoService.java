package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;

@Service //is same as Component
public class TodoService {
	private static List<Todo> todos=new ArrayList<>();
	private static int todoCount=3;
	
	static {
		todos.add(new Todo(1,"akash","Learn Spring with MVC",new Date(),false));
		todos.add(new Todo(2,"akash","Learn Struts",new Date(),false));
		todos.add(new Todo(3,"akash","Learn hibernate",new Date(),false));	
	}
	
	public String getTodos(){
		
		return null;
	}
	
	public List<Todo> retrieveTodos(String user){
		List<Todo> filteredTodos=new ArrayList<Todo>();
		for(Todo todo:todos) {
			if(todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;
	}
	
	public void addTodo(String name,String desc,Date targateDate,Boolean isDone) {
		todos.add(new Todo(++todoCount,name,desc,targateDate,isDone));
	}
	
	public Todo retrieveTodo(int id){
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		
		return null;
	}
	
	public void updateTodo(Todo todo){
		todos.remove(todo); //will delete using index
		todos.add(todo); //will add new todo with other index
	}
	
	public void deleteTodo(int id) {
			Iterator<Todo> iterator=todos.iterator();  //Iterator is a safe mode to use list elements
			while(iterator.hasNext()) {
				Todo todo=iterator.next();
				if(todo.getId()==id) {
					iterator.remove();
				}
			}
	}	
}

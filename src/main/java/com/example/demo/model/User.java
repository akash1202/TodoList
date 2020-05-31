package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="userdata")
public class User {
	
@Id
private int id;
private String username;

public int getId() {
return id;
}

public void setId(int id) {
	this.id=id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username=username;
}

@Override
public String toString() {
	return "User[id="+id+", uname"+username+"]";
}
}
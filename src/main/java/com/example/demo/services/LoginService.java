package com.example.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service //it is a Spring bean
public class LoginService {

	public Boolean validateUser(String username,String password) {
		return username.equals("akash")&&password.equals("akash");
	}
}

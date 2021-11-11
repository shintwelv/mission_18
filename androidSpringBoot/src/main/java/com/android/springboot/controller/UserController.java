package com.android.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.android.springboot.model.User;
import com.android.springboot.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/signin")
	public boolean signIn(@RequestBody User vo, HttpServletRequest request) {
		User user;
		try {
			user = service.select(vo);
		} catch (NullPointerException e) {
			user = null;
		}
		if(user != null) {
			if (user.getUserPassword().equals(vo.getUserPassword())) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value = "/signup")
	public boolean signUp(@RequestBody User vo) {
		System.out.println(vo);
		try {
			service.insert(vo);
			System.out.println(true);
			return true;
		} catch (Exception e) {
			System.out.println(false);
			return false;
		}
	}

}

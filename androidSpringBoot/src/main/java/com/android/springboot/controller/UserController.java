package com.android.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.android.springboot.model.User;
import com.android.springboot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/signin")
	public void signIn(User vo, HttpServletRequest request) {
		User user = service.select(vo);
		if(user != null) {
			request.setAttribute("loginChk", true);
		} else {
			request.setAttribute("loginChk", false);
		}
	}
	
	@RequestMapping(value = "/signup")
	public void signUp(User vo) {
		service.insert(vo);
	}

}

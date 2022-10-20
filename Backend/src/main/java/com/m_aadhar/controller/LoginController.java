package com.m_aadhar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m_aadhar.bean.Login;
import com.m_aadhar.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {
	
	@Autowired
	LoginService ls;
	
	@GetMapping(value = "note")
	public String note() {
		return ls.note();
	}
	
	@PostMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		 System.out.println(login);
		return ls.signIn(login);
	}
	
	@PostMapping(value = "signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		return ls.signUp(login);
	}
	


}

package com.m_aadhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m_aadhar.bean.Login;
import com.m_aadhar.service.LoginService;

@RestController
@RequestMapping("operation")
@CrossOrigin
public class OperationController {
	
	@Autowired
	LoginService ls;
	
	@PostMapping(value = "apply", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String apply(@RequestBody Login login) {
		return ls.storeUser(login);
	}
	
	@PatchMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody Login login) {
		return ls.update(login);
	}
	
	@GetMapping(value = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Login> getAllUser(){
		return ls.getAll();
	}
	
	@GetMapping(value = "getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Login> getOneUser(@PathVariable("id") int id){
		return ls.findById(id);
	}
	
	@DeleteMapping(value = "delete/{emailid}")
	public String deleteUser(@PathVariable("emailid") String emailid){
		return ls.delete(emailid);
	}
	
	
	
	

}

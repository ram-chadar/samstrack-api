package com.ram.samstrack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.samstrack.model.User;
import com.ram.samstrack.service.auth.Auth_Service;

@CrossOrigin
@RestController
@RequestMapping(value = "/samstrack/common")
public class Auth_Controller {
	
	@Autowired
	private Auth_Service auth_Service;
	
	@PostMapping(value = "/auth",headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> authenticate(@RequestBody User user,HttpSession httpSession){
		
		System.out.println(user.getUsername()+"\t"+user.getPassword());
		User usr=auth_Service.login(user);
		if(usr!=null)
		{
			httpSession.setAttribute("username", usr.getUsername());
			httpSession.setAttribute("userid", usr.getUser_Id());
			httpSession.setAttribute("usertype", usr.getUser_Type());
			httpSession.setAttribute("branch", usr.getBranch());
			return new ResponseEntity<Boolean>(true,HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);

		}
		
	}
	
	@GetMapping(value = "/logout")
	public ResponseEntity<String> logout(HttpSession httpSession,HttpServletRequest servletRequest)
	{
		auth_Service.logout(httpSession);
		httpSession=servletRequest.getSession();
		if(httpSession!=null)
		{
			httpSession.invalidate();
		}
		return new ResponseEntity<String>("Logout Successfully",HttpStatus.OK);
		
	}

}

package com.ram.samstrack.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ram.samstrack.model.User;
import com.ram.samstrack.service.user.User_Service;

@RestController
@RequestMapping(value = "/samstrack/common")
@CrossOrigin
public class User_Controller {

	@Autowired
	private User_Service user_Service;

	// Add User

	@PostMapping(value = "/add-user", headers = "Accept=application/json")
	public ResponseEntity<Serializable> addUser(@RequestBody User user, UriComponentsBuilder builder) {

		Serializable id = user_Service.addUser(user);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(builder.path("/user/{user_id}").buildAndExpand(user.getUser_Id()).toUri());
		if (id != null) {
			return new ResponseEntity<>(header, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

	}
	// Get All User

	@GetMapping(value = "/get-all-user", headers = "Accept=application/json")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> userList = user_Service.getAllUser();
		if (userList.isEmpty()) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
			
		} else {
			return new ResponseEntity<List<User>>(userList, HttpStatus.FOUND);
		}
	}
	
	@GetMapping(value = "/get-branch-user", headers = "Accept=application/json")
	public ResponseEntity<List<User>> getBranchUser( HttpSession httpSession) {
		List<User> userList = user_Service.getBranchUser(httpSession);
		if (userList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			return new ResponseEntity<List<User>>(userList, HttpStatus.FOUND);
		}
	}

	@GetMapping(value = "/get-user/{user_Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("user_Id") int user_id) {
		User user = user_Service.getUser(user_id);
		System.out.println(user);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	// Update User

	@PutMapping(value = "/update-user", headers = "Accept=application/json")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {

		user_Service.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/*
	 * @PutMapping(value = "/delete-user/{user_id}",
	 * headers="Accept=application/json") public ResponseEntity<Void>
	 * deleteUser(@PathVariable("user_id") int user_Id) {
	 * 
	 * user_Service.deleteUser(user_Id); return new
	 * ResponseEntity<Void>(HttpStatus.MOVED_PERMANENTLY); }
	 */

}

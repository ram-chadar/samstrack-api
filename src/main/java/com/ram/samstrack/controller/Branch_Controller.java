package com.ram.samstrack.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ram.samstrack.model.Branch;
import com.ram.samstrack.service.Branch_Service;

@CrossOrigin
@RestController
@RequestMapping(value = "/samstrack/principle")
public class Branch_Controller {

	@Autowired
	private Branch_Service branch_Service;
	
	
	
	@PostMapping(value = "/add-branch",headers="Accept=application/json")
	public ResponseEntity<Serializable> addBranch(@RequestBody Branch branch,UriComponentsBuilder builder)
	{
		Serializable id=branch_Service.addBranch(branch);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(builder.path("/branch/{branch_id}").buildAndExpand(branch.getBranch_Id()).toUri());
	
	     if(id!=null)
	     {
	    	 return new ResponseEntity<>(headers,HttpStatus.CREATED);
	     }
	     else
	     {
	    	 return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	     }
	     
	}
	
}

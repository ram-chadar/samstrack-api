package com.ram.samstrack.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.samstrack.model.Allocate_Practical_Subject;
import com.ram.samstrack.model.Allocate_Theory_Subject;
import com.ram.samstrack.service.allocate_subject.Allocate_Subject_Service;

@CrossOrigin
@RestController
@RequestMapping(value = "/samstrack/hod")
public class Allocate_Subject_Controller {

	@Autowired
	private Allocate_Subject_Service allocate;
		
	@PutMapping(value = "/allocate-theory-subject",headers = "Accept=application/json")
	public ResponseEntity<Void> allocate_Theory_Subject(@RequestBody Allocate_Theory_Subject allocate_Theory_Subject)
	{
		allocate.allocate_Theory_Subject(allocate_Theory_Subject);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/allocate-practical-subject",headers = "Accept=application/json")
	public ResponseEntity<Void> allocate_Practical_Subject(@RequestBody Allocate_Practical_Subject allocate_Practical_Subject)
	{
		allocate.allocate_Practical_Subject(allocate_Practical_Subject);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/get-allocated-theory-subject",headers = "Accept=application/json")
	public ResponseEntity<List<Allocate_Theory_Subject>> get_Allocated_Theory_Subject(@RequestBody Allocate_Theory_Subject allocated_Theory_Subject)
	{
		List<Allocate_Theory_Subject>list=allocate.get_Allocated_Theory_Subject(allocated_Theory_Subject);
		if(!list.isEmpty())
		{
			return new ResponseEntity<List<Allocate_Theory_Subject>>(list,HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/get-allocated-practical-subject",headers = "Accept=application/json")
	public ResponseEntity<List<Allocate_Practical_Subject>> get_Allocated_Prctical_Subject(@RequestBody Allocate_Practical_Subject allocate_Practical_Subject)
	{
		List<Allocate_Practical_Subject>list=allocate.get_Allocated_Prctical_Subject(allocate_Practical_Subject);
		if(!list.isEmpty())
		{
			return new ResponseEntity<List<Allocate_Practical_Subject>>(list,HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/list_allocated_theory_subjects",headers = "Accept=application/json")
	public ResponseEntity<List<Allocate_Theory_Subject>> list_Allocated_Theory_Subjects(@RequestBody Allocate_Theory_Subject allocated_Theory_Subject,HttpSession httpSession){
		
		List<Allocate_Theory_Subject> list=allocate.list_Allocated_Theory_Subjects(allocated_Theory_Subject, httpSession);
		
		if(!list.isEmpty()) {
			return new ResponseEntity<List<Allocate_Theory_Subject>>(list,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<List<Allocate_Theory_Subject>>(HttpStatus.NOT_FOUND);

		}
		
	}
	
	@PutMapping(value = "/list_allocated_practical_subjects",headers = "Accept=application/json")
	public ResponseEntity<List<Allocate_Practical_Subject>> list_Allocated_Practical_Subjects(@RequestBody Allocate_Practical_Subject allocated_Theory_Subject,HttpSession httpSession){
		
		List<Allocate_Practical_Subject> list=allocate.list_Allocated_Practical_Subjects(allocated_Theory_Subject, httpSession);
		
		if(!list.isEmpty()) {
			return new ResponseEntity<List<Allocate_Practical_Subject>>(list,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<List<Allocate_Practical_Subject>>(HttpStatus.NOT_FOUND);

		}
		
		
	}
			
}

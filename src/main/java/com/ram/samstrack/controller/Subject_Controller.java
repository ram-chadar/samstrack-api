package com.ram.samstrack.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.ram.samstrack.model.Allocate_Theory_Subject;
import com.ram.samstrack.model.Subject;
import com.ram.samstrack.service.subject.Subject_Service;

@CrossOrigin
@RestController
@RequestMapping(value = "/samstrack/hod")
public class Subject_Controller {

	@Autowired
	Subject_Service subject_Service;

	@PostMapping(value = "/add-subject", headers = "Accept=application/json")
	public ResponseEntity<Serializable> add_Subject(@RequestBody Subject subject, UriComponentsBuilder builder) {

		Serializable id = subject_Service.add_Subject(subject);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subject/{subject_id}").buildAndExpand(subject.getSubject_Id()).toUri());
		if (id != null) {
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

		}

	}

	@GetMapping(value = "/get-all-branch-subject/{branch_id}", headers = "Accept=application/json")
	public ResponseEntity<List<Subject>> gel_All_Branch_Subject(@PathVariable("branch_id") int branch_Id) {
		List<Subject> subjectList = subject_Service.get_Branch_Subject(branch_Id);
		if (!subjectList.isEmpty()) {
			return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(value = "/get-all-branch-sem-subject", headers = "Accept=application/json")
	public ResponseEntity<List<Subject>> getAll_Branch_Sem_Subject(@RequestBody Subject subject) {

		List<Subject> subjectList = subject_Service.get_Branch_Sem_Subject(subject.getBranch().getBranch_Id(),
				subject.getSem());

		if (!subjectList.isEmpty()) {
			return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.FOUND);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}
	
	@PutMapping(value = "get_theory_practical_subject", headers = "Accept=application/json")
	public ResponseEntity<List<Subject>> get_Theory_Practical_Subject(@RequestBody Subject subject)
	{
		List<Subject> subjectList=subject_Service.get_Theory_Practical_Subject(
				subject.getBranch().getBranch_Id(), subject.getSem(), subject.getSubject_Type());
		
		if(!subjectList.isEmpty())
		{
			return new ResponseEntity<List<Subject>>(subjectList,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>(HttpStatus.FOUND);

		}
		
	}
	
	

}

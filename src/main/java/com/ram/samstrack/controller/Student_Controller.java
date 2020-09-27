package com.ram.samstrack.controller;

import java.io.Serializable;
import java.util.List;

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

import com.ram.samstrack.model.Batch;
import com.ram.samstrack.model.Student;
import com.ram.samstrack.service.student.Student_Service;

@CrossOrigin
@RestController
@RequestMapping(value = "/samstrack/common")
public class Student_Controller {

	@Autowired
	private Student_Service student_Service;

	@PostMapping(value = "/add-student", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> add_Student(@RequestBody Student student, UriComponentsBuilder builder) {

		Serializable id = student_Service.add_Student(student);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subject/{subject_id}").buildAndExpand(student.getStudent_Id()).toUri());
		if (id != null) {
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

		}

	}
	
	@GetMapping(value = "/get-student/{student_id}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> get_Student(@PathVariable("student_id") int student_Id) {

		Student student = student_Service.get_Student(student_Id);

		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(value = "/get-all-student", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> get_All_Student(@RequestBody Student student) {
		List<Student> studentList = student_Service.get_All_Student(student.getAcc_Year(), student.getYear(),
				student.getBranch().getBranch_Id(), student.getDivision());
		if (!studentList.isEmpty()) {
			return new ResponseEntity<List<Student>>(studentList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping(value = "/get-students-for-practical", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> get_Students_For_Practical(@RequestBody Student student) {
		List<Student> studentList = student_Service.get_Students_For_Practical(student.getAcc_Year(), student.getYear(),
				student.getBranch().getBranch_Id(), student.getDivision(),student.getBatch());
		if (!studentList.isEmpty()) {
			return new ResponseEntity<List<Student>>(studentList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping(value = "/generate-batch", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> generate_Batch(@RequestBody Batch batch)
	{
		int count=student_Service.generate_Batch(batch);
		if(count>0)
		{
			return new ResponseEntity<Integer>(count,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Integer>(0,HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	@PutMapping(value = "update-student", headers = "Accept=application/json",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update_Student(@RequestBody Student student)
	{
		student_Service.update_Student(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

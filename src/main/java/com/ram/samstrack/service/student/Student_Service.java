package com.ram.samstrack.service.student;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.Student;

public interface Student_Service {

	public Serializable add_Student(Student student);
	public Student get_Student(int student_Id);
	public List<Student> get_All_Student();
}

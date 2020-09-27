package com.ram.samstrack.service.student;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.Batch;
import com.ram.samstrack.model.Student;

public interface Student_Service {

	public Serializable add_Student(Student student);
	
	public Student get_Student(int student_Id);
	public List<Student> get_All_Student(int acc_Year,String year,int branch_Id,char division);
	public List<Student> get_Students_For_Practical(int acc_Year,String year,int branch_Id,char division,String batch);
	
	public int generate_Batch(Batch batch);
	public void update_Student (Student student);
}

package com.ram.samstrack.service.student;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.samstrack.dao.student.Student_Dao;
import com.ram.samstrack.model.Batch;
import com.ram.samstrack.model.Student;

@Service
@Transactional
public class Student_ServiceImpl  implements Student_Service{

	@Autowired
	private Student_Dao student_Dao;
		
	@Override
	public Serializable add_Student(Student student) {
		return student_Dao.add_Student(student);
	}

	@Override
	public Student get_Student(int student_Id) {
		return student_Dao.get_Student(student_Id);
	}

	@Override
	public List<Student> get_All_Student(int acc_Year,String year,int branch_Id,char division) {
		return student_Dao.get_All_Student(acc_Year, year, branch_Id, division);
	}

	@Override
	public List<Student> get_Students_For_Practical(int acc_Year, String year, int branch_Id, char division,
			String batch) {
		return student_Dao.get_Students_For_Practical(acc_Year, year, branch_Id, division, batch);
	}

	

	@Override
	public int generate_Batch(Batch batch) {
		return student_Dao.generate_Batch(batch);
	}

	@Override
	public void update_Student(Student student) {
		 student_Dao.update_Student(student);
	}

}

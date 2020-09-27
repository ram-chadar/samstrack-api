package com.ram.samstrack.service.subject;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.Allocate_Theory_Subject;
import com.ram.samstrack.model.Subject;

public interface Subject_Service {

	public Serializable add_Subject(Subject subject);
	
	public List<Subject> get_Branch_Subject(int branch_Id); 
	public List<Subject> get_Branch_Sem_Subject(int branch_Id,int sem);
	
	public List<Subject> get_Theory_Practical_Subject(int branch_Id,int sem,String subject_Type);
	
	
	
	
}

package com.ram.samstrack.dao.subject;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.Subject;

public interface Subject_Dao {
	
	public Serializable add_Subject(Subject subject);

	public List<Subject> gel_All_Branch_Subject(int branch_Id);

	public List<Subject> get_All_Branch_Sem_Subject(int branch_Id, int sem);

}

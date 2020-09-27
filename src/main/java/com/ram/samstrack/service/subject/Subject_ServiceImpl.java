package com.ram.samstrack.service.subject;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.samstrack.dao.subject.Subject_Dao;
import com.ram.samstrack.model.Allocate_Theory_Subject;
import com.ram.samstrack.model.Subject;

@Service
@Transactional
public class Subject_ServiceImpl implements Subject_Service {
	@Autowired
	private Subject_Dao subject_Dao;
		
	@Override
	public Serializable add_Subject(Subject subject) {
		return subject_Dao.add_Subject(subject);
	}

	@Override
	public List<Subject> get_Branch_Subject(int branch_Id) {
		return subject_Dao.get_Branch_Subject(branch_Id);
	}

	@Override
	public List<Subject> get_Branch_Sem_Subject(int branch_Id, int sem) {
		// TODO Auto-generated method stub
		return subject_Dao.get_Branch_Sem_Subject(branch_Id, sem);
	}

	

	@Override
	public List<Subject> get_Theory_Practical_Subject(int branch_Id, int sem,String subject_Type) {
		return subject_Dao.get_Theory_Practical_Subject(branch_Id, sem,subject_Type);
	}


}

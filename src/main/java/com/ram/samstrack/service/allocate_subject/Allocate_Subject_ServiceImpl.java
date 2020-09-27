package com.ram.samstrack.service.allocate_subject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.samstrack.dao.allocate_subject.Allocate_Subject_Dao;
import com.ram.samstrack.model.Allocate_Practical_Subject;
import com.ram.samstrack.model.Allocate_Theory_Subject;

@Service
@Transactional
public class Allocate_Subject_ServiceImpl implements Allocate_Subject_Service {

	@Autowired
	private Allocate_Subject_Dao allocate_Subject_Dao;

	@Override
	public void allocate_Theory_Subject(Allocate_Theory_Subject allocate_Theory_Subject) {
		allocate_Subject_Dao.allocate_Theory_Subject(allocate_Theory_Subject);
	}

	@Override
	public void allocate_Practical_Subject(Allocate_Practical_Subject allocate_Practical_Subject) {
		allocate_Subject_Dao.allocate_Practical_Subject(allocate_Practical_Subject);
	}

	@Override
	public List<Allocate_Theory_Subject> get_Allocated_Theory_Subject(Allocate_Theory_Subject allocated_Theory_Subject) {
		// TODO Auto-generated method stub
		return allocate_Subject_Dao.get_Allocated_Theory_Subject(allocated_Theory_Subject);
	}

	@Override
	public List<Allocate_Practical_Subject> get_Allocated_Prctical_Subject(Allocate_Practical_Subject allocated_Practical_Subject) {
		
		return allocate_Subject_Dao.get_Allocated_Prctical_Subject(allocated_Practical_Subject);
	}

	@Override
	public List<Allocate_Theory_Subject> list_Allocated_Theory_Subjects(
			Allocate_Theory_Subject allocated_Theory_Subject,HttpSession httpSession) {
		return allocate_Subject_Dao.list_Allocated_Theory_Subjects(allocated_Theory_Subject, httpSession);
	}

	@Override
	public List<Allocate_Practical_Subject> list_Allocated_Practical_Subjects(
			Allocate_Practical_Subject allocated_Practical_Subject,HttpSession httpSession) {
		return allocate_Subject_Dao.list_Allocated_Practical_Subjects(allocated_Practical_Subject, httpSession);
	}

}

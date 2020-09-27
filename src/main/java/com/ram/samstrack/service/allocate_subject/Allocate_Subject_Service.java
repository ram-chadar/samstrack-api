package com.ram.samstrack.service.allocate_subject;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ram.samstrack.model.Allocate_Practical_Subject;
import com.ram.samstrack.model.Allocate_Theory_Subject;

public interface Allocate_Subject_Service {
//add
	public void allocate_Theory_Subject(Allocate_Theory_Subject allocated_Theory_Subject);
	public void allocate_Practical_Subject(Allocate_Practical_Subject allocate_Practical_Subject);

//allocated subject	
	public List<Allocate_Theory_Subject> get_Allocated_Theory_Subject(Allocate_Theory_Subject allocated_Theory_Subject);
	public List<Allocate_Practical_Subject> get_Allocated_Prctical_Subject(Allocate_Practical_Subject allocated_Practical_Subject);
	
//list of allocated subject	
	public List<Allocate_Theory_Subject> list_Allocated_Theory_Subjects(Allocate_Theory_Subject allocated_Theory_Subject,HttpSession httpSession);
	public List<Allocate_Practical_Subject> list_Allocated_Practical_Subjects(Allocate_Practical_Subject allocated_Practical_Subject,HttpSession httpSession);
	
}

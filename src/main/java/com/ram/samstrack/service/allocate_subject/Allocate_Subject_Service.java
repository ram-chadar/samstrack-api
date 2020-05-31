package com.ram.samstrack.service.allocate_subject;

import java.io.Serializable;
import java.util.List;

import com.ram.samstrack.model.Allocate_Practical_Subject;
import com.ram.samstrack.model.Allocate_Theory_Subject;

public interface Allocate_Subject_Service {
//add
	public Serializable allocate_Theory_Subject(Allocate_Theory_Subject allocated_Theory_Subject);
	public Serializable allocate_Practical_Subject(Allocate_Practical_Subject allocate_Practical_Subject);

//allocated subject	
	public Allocate_Theory_Subject get_Allocated_Theory_Subject(Allocate_Theory_Subject allocate_Theory_Subject);
	public Allocate_Practical_Subject get_Allocated_Prcticl_Subject(Allocate_Practical_Subject allocate_Practical_Subject);
	
//list of allocated subject	
	public List<Allocate_Theory_Subject> list_Allocated_Theory_Subjects(Allocate_Theory_Subject allocate_Theory_Subject);
	public List<Allocate_Practical_Subject> list_Allocated_Practical_Subjects(Allocate_Practical_Subject allocate_Practical_Subject);
	
}

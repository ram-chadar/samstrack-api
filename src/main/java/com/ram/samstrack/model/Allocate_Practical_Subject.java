package com.ram.samstrack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="allocated_practical_subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Allocate_Practical_Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "aps_id")
	@TableGenerator(name = "aps_id")
	@Column(name="aps_id",nullable = false)
	private int aps_Id;
	
	@ManyToOne(targetEntity = Branch.class)
	@JoinColumn(name = "branch_id",nullable = false)
	private Branch branch;
	
	@Column(name = "division",nullable = false)
	private char division;
	
	@Column(name = "sem",nullable = false)
	private int sem;
	
	@Column(name = "batch",nullable = false)
	private String batch;
	
	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name = "subject_id",nullable = false)
	private Subject subject;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	public Allocate_Practical_Subject() {
		// TODO Auto-generated constructor stub
	}

	
	public int getAps_Id() {
		return aps_Id;
	}


	public void setAps_Id(int aps_Id) {
		this.aps_Id = aps_Id;
	}


	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public char getDivision() {
		return division;
	}

	public void setDivision(char division) {
		this.division = division;
	}
	
	

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Allocated_Practical_Subject [ats_Id=" + aps_Id + ", branch=" + branch + ", division=" + division
				+ ", sem=" + sem + ", batch=" + batch + ", subject=" + subject + ", user=" + user + "]";
	}

	
	
	
	
	
}

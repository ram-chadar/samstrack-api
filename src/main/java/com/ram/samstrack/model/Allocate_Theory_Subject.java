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
@Table(name="allocated_theory_subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Allocate_Theory_Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "ats_id")
	@TableGenerator(name = "ats_id")
	@Column(name = "ats_id", nullable = false)
	private int ats_Id;

	@ManyToOne(targetEntity = Branch.class)
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch branch;

	@Column(name = "division", nullable = false)
	private char division;

	@Column(name = "sem", nullable = false)
	private int sem;

	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name = "subject_id", nullable = false)
	private Subject subject;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Allocate_Theory_Subject() {
		// TODO Auto-generated constructor stub
	}

	public int getAts_Id() {
		return ats_Id;
	}

	public void setAts_Id(int ats_Id) {
		this.ats_Id = ats_Id;
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
		return "Allocated_Theory_Subject [ats_Id=" + ats_Id + ", branch=" + branch + ", division=" + division + ", sem="
				+ sem + ", subject=" + subject + ", user=" + user + "]";
	}

	
}

package com.ram.samstrack.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name="subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "subject_id")
	@TableGenerator(name = "subject_id")
	@Column(name="subject_id",nullable = false)
	private int subject_Id;
	
	@ManyToOne(targetEntity = Branch.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id",nullable = false)
	private Branch branch;
	
	@Column(name = "sem",nullable = false)
	private int sem;
	
	@Column(name = "subject_name",nullable = false)
	private String subject_Name;
	
	@Column(name = "subject_code")
	private long subject_Code;
	
	@Column(name = "subject_type",nullable = false)
	private String subject_Type;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public int getSubject_Id() {
		return subject_Id;
	}

	public void setSubject_Id(int subject_Id) {
		this.subject_Id = subject_Id;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public String getSubject_Name() {
		return subject_Name;
	}

	public void setSubject_Name(String subject_Name) {
		this.subject_Name = subject_Name;
	}

	public long getSubject_Code() {
		return subject_Code;
	}

	public void setSubject_Code(long subject_Code) {
		this.subject_Code = subject_Code;
	}

	public String getSubject_Type() {
		return subject_Type;
	}

	public void setSubject_Type(String subject_Type) {
		this.subject_Type = subject_Type;
	}

	@Override
	public String toString() {
		return "Subject [subject_Id=" + subject_Id + ", branch=" + branch + ", sem=" + sem + ", subject_Name="
				+ subject_Name + ", subject_Code=" + subject_Code + ", subject_Type=" + subject_Type + "]";
	}
	
	
	
	
}

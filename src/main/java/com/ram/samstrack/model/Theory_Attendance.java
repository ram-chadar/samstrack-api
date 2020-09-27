package com.ram.samstrack.model;

import java.io.Serializable;


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
@Table(name="theory_attendance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Theory_Attendance implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "ta_id")
	@TableGenerator(name = "ta_id")
	@Column(name="ta_id",nullable = false)
	private int ta_Id;
	
	@Column(name = "date_time",nullable = false)
	private String date_Time;
	
	@ManyToOne(targetEntity = Branch.class)
	@JoinColumn(name = "branch_id",nullable = false)
	private Branch branch;
	
	@Column(name = "division",nullable = false)
	private char division;
	
	@Column(name = "sem",nullable = false)
	private int sem;
	

	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name = "subject_id",nullable = false)
	private Subject subject;
	
	
	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id",nullable = false)
	private Student student;
	
	@Column(name = "month",nullable = false)
	private int month;
	
	@Column(name = "acc_year",nullable = false)
	private int acc_Year;
	
	public Theory_Attendance() {
		// TODO Auto-generated constructor stub
	}

	public int getTa_Id() {
		return ta_Id;
	}

	public void setTa_Id(int ta_Id) {
		this.ta_Id = ta_Id;
	}

	public String getDate_Time() {
		return date_Time;
	}

	public void setDate_Time(String date_Time) {
		this.date_Time = date_Time;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getAcc_Year() {
		return acc_Year;
	}

	public void setAcc_Year(int acc_Year) {
		this.acc_Year = acc_Year;
	}

	@Override
	public String toString() {
		return "Treory_Attendance [ta_Id=" + ta_Id + ", date_Time=" + date_Time + ", branch=" + branch + ", division="
				+ division + ", sem=" + sem + ", subject=" + subject + ", student=" + student + ", month=" + month
				+ ", acc_Year=" + acc_Year + "]";
	}
	
	

}

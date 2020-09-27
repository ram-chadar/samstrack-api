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
@Table(name = "practical_sem_status")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Practical_Sem_Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "pss_id")
	@TableGenerator(name = "pss_id")
	@Column(name = "pss_id", nullable = false)
	private int pss_Id;

	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

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

	@Column(name = "status", nullable = false)
	private float status;

	@Column(name = "acc_year", nullable = false)
	private int acc_Year;

	@Column(name = "days", nullable = false)
	private String days;
	
	@Column(name = "batch" ,nullable = false)
	private String batch;
	
	public Practical_Sem_Status() {
		// TODO Auto-generated constructor stub
	}

	
	public int getPss_Id() {
		return pss_Id;
	}


	public void setPss_Id(int pss_Id) {
		this.pss_Id = pss_Id;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public float getStatus() {
		return status;
	}

	public void setStatus(float status) {
		this.status = status;
	}

	public int getAcc_Year() {
		return acc_Year;
	}

	public void setAcc_Year(int acc_Year) {
		this.acc_Year = acc_Year;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Practical_Month_Status [pms_Id=" + pss_Id + ", student=" + student + ", branch=" + branch
				+ ", division=" + division + ", sem=" + sem + ", subject=" + subject + ", status=" + status
				+ ", acc_Year=" + acc_Year + ", days=" + days + ", batch=" + batch + "]";
	}
	
	

}

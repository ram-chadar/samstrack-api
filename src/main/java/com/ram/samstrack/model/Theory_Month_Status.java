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
@Table(name = "theory_month_status")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Theory_Month_Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "tms_id")
	@TableGenerator(name = "tms_id")
	@Column(name = "tms_id", nullable = false)
	private int tms_Id;

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

	@Column(name = "month", nullable = false)
	private int month;

	@Column(name = "days", nullable = false)
	private String days;

	public Theory_Month_Status() {
		// TODO Auto-generated constructor stub
	}

	public int getTms_Id() {
		return tms_Id;
	}

	public void setTms_Id(int tms_Id) {
		this.tms_Id = tms_Id;
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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Theory_Month_Status [tms_Id=" + tms_Id + ", student=" + student + ", branch=" + branch + ", division="
				+ division + ", sem=" + sem + ", subject=" + subject + ", status=" + status + ", acc_Year=" + acc_Year
				+ ", month=" + month + ", days=" + days + "]";
	}
	
	

}

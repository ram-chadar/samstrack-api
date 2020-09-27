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
@Table(name="student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "student_id")
	@TableGenerator(name = "student_id")
	@Column(name="student_id",nullable = false)
	private int student_Id;
	
	@Column(name = "acc_year" ,nullable = false)
	private int acc_Year;
	
	@ManyToOne(targetEntity = Branch.class)
	@JoinColumn(name = "branch_id",nullable = false)
	private Branch branch;
	
	@Column(name = "year" ,nullable = false)
	private String year;
	
	@Column(name = "division" ,nullable = false)
	private char division;
	
	@Column(name = "batch")
	private String batch;
	
	@Column(name = "roll_no" ,nullable = false)
	private int roll_No;
	
	
	@Column(name = "student_name" ,nullable = false)
	private String student_Name;
	
	@Column(name = "gender" ,nullable = false)
	private String gender;
	
	
	@Column(name = "mail" ,nullable = false ,unique = true)
	private String mail;
	
	@Column(name = "student_phone" ,unique = true )
	private String student_Phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "father_name")
	private String father_Name;
	
	@Column(name = "mother_name")
	private String mother_Name;
	
	@Column(name = "parent_phone",unique = true)
	private String parent_Phone;
	
public Student() {
	// TODO Auto-generated constructor stub
}

public int getStudent_Id() {
	return student_Id;
}

public void setStudent_Id(int student_Id) {
	this.student_Id = student_Id;
}

public int getAcc_Year() {
	return acc_Year;
}

public void setAcc_Year(int acc_Year) {
	this.acc_Year = acc_Year;
}

public Branch getBranch() {
	return branch;
}

public void setBranch(Branch branch) {
	this.branch = branch;
}

public String getYear() {
	return year;
}

public void setYear(String year) {
	this.year = year;
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

public int getRoll_No() {
	return roll_No;
}

public void setRoll_No(int roll_No) {
	this.roll_No = roll_No;
}

public String getStudent_Name() {
	return student_Name;
}

public void setStudent_Name(String student_Name) {
	this.student_Name = student_Name;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public String getStudent_Phone() {
	return student_Phone;
}

public void setStudent_Phone(String student_Phone) {
	this.student_Phone = student_Phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getFather_Name() {
	return father_Name;
}

public void setFather_Name(String father_Name) {
	this.father_Name = father_Name;
}

public String getMother_Name() {
	return mother_Name;
}

public void setMother_Name(String mother_Name) {
	this.mother_Name = mother_Name;
}

public String getParent_Phone() {
	return parent_Phone;
}

public void setParent_Phone(String parent_Phone) {
	this.parent_Phone = parent_Phone;
}


}

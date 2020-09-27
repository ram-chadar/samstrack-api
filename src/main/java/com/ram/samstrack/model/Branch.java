package com.ram.samstrack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="branch")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Branch implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "branch_id")
	@TableGenerator(name = "branch_id")	
	@Column(name="branch_id",nullable = false)
	private int branch_Id;
	
	@Column(name = "branch_name", nullable = false,length = 100,unique = true)
	private String branch_Name;
	
	@Column(name = "branch_code",nullable = false,length = 10,unique = true)
	private Long branch_Code;	

	
	public Branch() {
		// TODO Auto-generated constructor stub
	}


	public int getBranch_Id() {
		return branch_Id;
	}


	public void setBranch_Id(int branch_Id) {
		this.branch_Id = branch_Id;
	}


	public String getBranch_Name() {
		return branch_Name;
	}


	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}


	public Long getBranch_Code() {
		return branch_Code;
	}


	public void setBranch_Code(Long branch_Code) {
		this.branch_Code = branch_Code;
	}


	@Override
	public String toString() {
		return "Branch [branch_Id=" + branch_Id + ", branch_Name=" + branch_Name + ", branch_Code=" + branch_Code + "]";
	}
	
	
}

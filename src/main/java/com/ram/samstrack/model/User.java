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
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "user_id")
	@TableGenerator(name = "user_id")
	@Column(name="user_id",nullable = false)
	private int user_Id;
	
	@Column(name = "username",nullable = false ,unique = true)
	private String username;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "user_type",nullable = false)
	private String user_Type;
	
	@Column(name = "question",nullable = false)
	private String question;
	
	@Column(name = "answer",nullable = false)
	private String answer;
	
	@Column(name = "mail",nullable = false)
	private String mail;
	
	@ManyToOne(targetEntity = Branch.class)
	@JoinColumn(name = "branch_id",nullable = false)
	private Branch branch;
	
	@Column(name = "active")
	private int active=0;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public User(int user_Id, String username, String password, String user_Type, String question, String answer,
			String mail, Branch branch, int active) {
		super();
		this.user_Id = user_Id;
		this.username = username;
		this.password = password;
		this.user_Type = user_Type;
		this.question = question;
		this.answer = answer;
		this.mail = mail;
		this.branch = branch;
		this.active = active;
	}



	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_Type() {
		return user_Type;
	}

	public void setUser_Type(String user_Type) {
		this.user_Type = user_Type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", username=" + username + ", password=" + password + ", user_Type="
				+ user_Type + ", question=" + question + ", answer=" + answer + ", mail=" + mail + ", branch=" + branch
				+ ", active=" + active + "]";
	}
	
	
}

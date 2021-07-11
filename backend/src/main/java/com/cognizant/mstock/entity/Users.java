package com.cognizant.mstock.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	private int user_id;
	private String user_name;
	private long user_contact;
	private String user_email;
	private String user_pwd;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public long getUser_contact() {
		return user_contact;
	}
	public void setUser_contact(long user_contact) {
		this.user_contact = user_contact;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_name=" + user_name + ", user_contact=" + user_contact
				+ ", user_email=" + user_email + ", user_pwd=" + user_pwd + "]";
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int user_id, String user_name, long user_contact, String user_email, String user_pwd) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_contact = user_contact;
		this.user_email = user_email;
		this.user_pwd = user_pwd;
	}
	
	

}

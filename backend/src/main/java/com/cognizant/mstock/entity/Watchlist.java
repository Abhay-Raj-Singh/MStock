package com.cognizant.mstock.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="watchlist")
public class Watchlist {
	
	
	private int company_id;
	@Id
	private int user_id;
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	public Watchlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Watchlist [company_id=" + company_id + ", user_id=" + user_id + "]";
	}
	
	

}

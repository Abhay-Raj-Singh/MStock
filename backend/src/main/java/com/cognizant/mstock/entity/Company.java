package com.cognizant.mstock.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	private int company_id;
	private String company_name;
	private String company_des;
	private int avg_price_2019;
	private int avg_price_2020;
	private int avg_price_2021;
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_des() {
		return company_des;
	}
	public void setCompany_des(String company_des) {
		this.company_des = company_des;
	}
	
	public int getAvg_price_2019() {
		return avg_price_2019;
	}
	public void setAvg_price_2019(int avg_price_2019) {
		this.avg_price_2019 = avg_price_2019;
	}
	public int getAvg_price_2020() {
		return avg_price_2020;
	}
	public void setAvg_price_2020(int avg_price_2020) {
		this.avg_price_2020 = avg_price_2020;
	}
	public int getAvg_price_2021() {
		return avg_price_2021;
	}
	public void setAvg_price_2021(int avg_price_2021) {
		this.avg_price_2021 = avg_price_2021;
	}
	
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int company_id, String company_name, String company_des, int avg_price_2019, int avg_price_2020,
			int avg_price_2021) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.company_des = company_des;
		this.avg_price_2019 = avg_price_2019;
		this.avg_price_2020 = avg_price_2020;
		this.avg_price_2021 = avg_price_2021;
	}
	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_name=" + company_name + ", company_des=" + company_des
				+ ", avg_price_2019=" + avg_price_2019 + ", avg_price_2020=" + avg_price_2020 + ", avg_price_2021="
				+ avg_price_2021 + "]";
	}
	
}

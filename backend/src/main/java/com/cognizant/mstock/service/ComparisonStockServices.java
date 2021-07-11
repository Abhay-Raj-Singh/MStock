package com.cognizant.mstock.service;

import java.util.List;

import com.cognizant.mstock.entity.Company;

public interface ComparisonStockServices {

	public List<Company> getstockcompare(String company1, String company2);
	

}

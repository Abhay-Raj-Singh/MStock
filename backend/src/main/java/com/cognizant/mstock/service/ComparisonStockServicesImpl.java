package com.cognizant.mstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mstock.dao.ComparisonStockDao;
import com.cognizant.mstock.entity.Company;

@Service
public class ComparisonStockServicesImpl implements ComparisonStockServices{

	@Autowired
	ComparisonStockDao comparisonStockDao;
	
	@Override
	public List<Company> getstockcompare(String company1, String company2) {
		// TODO Auto-generated method stub
		return comparisonStockDao.getStockInfo1(company1,company2);
	}

}

package com.cognizant.mstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mstock.dao.CompanyStockDao;
import com.cognizant.mstock.entity.Company;


@Service
public class CompanyStockServicesImpl implements CompanyStockServices {
	
	
		@Autowired
		private CompanyStockDao companydao;

		@Override
		public List<Company> findcompany() {
			// TODO Auto-generated method stub
			return companydao.findcompany();
		}

		

		

	

}

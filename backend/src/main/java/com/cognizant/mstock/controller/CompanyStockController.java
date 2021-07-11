package com.cognizant.mstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mstock.entity.Company;
import com.cognizant.mstock.service.CompanyStockServices;



@RestController
@CrossOrigin
@RequestMapping("api/stock")
public class CompanyStockController 
{
		@Autowired
		private CompanyStockServices companyStockServices;
		
		@GetMapping("/companystocks")
		@RequestMapping(method = RequestMethod.GET,value="/companystocks")
		public ResponseEntity<List<Company>> companyStockDetails()
		{
		   List<Company>company= companyStockServices.findcompany();
		   return new  ResponseEntity<List<Company>>( company, HttpStatus.OK); 
		   
		}

}

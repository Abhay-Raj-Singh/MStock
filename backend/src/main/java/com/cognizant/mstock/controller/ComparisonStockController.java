package com.cognizant.mstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mstock.entity.Company;
import com.cognizant.mstock.exception.InvalidCompanyException;
import com.cognizant.mstock.service.ComparisonStockServices;

@RestController
@CrossOrigin
@RequestMapping("api/stock")
public class ComparisonStockController {
	
	@Autowired
	ComparisonStockServices comparisonStockServices;
	
	
	@RequestMapping(value = "comparison/{company1}/{company2}/{year}", method = RequestMethod.GET)
	
	public ResponseEntity<List<Company>> getstockcompare(
			@PathVariable("company1") String company1, @PathVariable("company2") String company2) 
			throws InvalidCompanyException
	{
		
		List<Company> com= comparisonStockServices.getstockcompare(company1,company2) ;
		
		if(com.size()<=1) {
			throw new InvalidCompanyException("Invalid Entry for Company");
		}
		
		return new ResponseEntity<List<Company>>(com,HttpStatus.OK);
	}
	

	
	
	@ExceptionHandler(value=InvalidCompanyException.class)
	  public ResponseEntity<String> exceptionHandler(Exception ex) {
		  
		  return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	  }
	
}

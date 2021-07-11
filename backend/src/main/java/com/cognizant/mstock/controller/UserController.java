package com.cognizant.mstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mstock.entity.Company;
import com.cognizant.mstock.entity.Users;
import com.cognizant.mstock.exception.InvalidCompanyException;
import com.cognizant.mstock.exception.UserAlreadyPresentException;
import com.cognizant.mstock.service.WatchlistService;
import com.cognizant.mstock.service.userService;




@RestController
@CrossOrigin
@RequestMapping("api/stock")
public class UserController {
	
	@Autowired
	userService userService;
	@Autowired
	WatchlistService watchlistService;
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST,value="/login")
	public ResponseEntity<Users> validate(@RequestBody Users login) {
		Users status = userService.validateUserLogin(login.getUser_email(), login.getUser_pwd());
		
		
		
		
		if (status!=null)
			return new ResponseEntity<Users>( status, HttpStatus.OK);
		else
			return null;
	}
	
//	add to watch list
	
	@RequestMapping(method = RequestMethod.POST,value="watchlist/addCompany/{user_id}")
	 public ResponseEntity<Boolean> addUser(@RequestBody Company company,@PathVariable("user_id") int user_id) throws UserAlreadyPresentException {
		 return new ResponseEntity<Boolean>( watchlistService.addCompany(company,user_id), HttpStatus.OK);
	       
	    }
	
	@RequestMapping(method = RequestMethod.GET,value="/watchlist/displayAll/{user_id}")
	public ResponseEntity< List<Company>> watchListOfUser(@PathVariable("user_id") int user_id) throws UserAlreadyPresentException {

		List<Company> company_watchlist= watchlistService.findWatchlist(user_id);
		return new ResponseEntity< List<Company>>( company_watchlist, HttpStatus.OK);
	

	}
	
	@ExceptionHandler(value=UserAlreadyPresentException.class)
	  public ResponseEntity<String> exceptionHandler(Exception ex) {
		  
		  return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	  }
	
//	delete from watch list
	
	@RequestMapping(method = RequestMethod.DELETE,value={"watchlist/deleteCompany/{user_id}/{company_id}"})
	 public ResponseEntity<Boolean> deleteUser(@PathVariable("user_id") int user_id,@PathVariable("company_id") int company_id) throws InvalidCompanyException{
		 return new ResponseEntity<Boolean>( watchlistService.deleteCompany(company_id,user_id), HttpStatus.OK);
	       
	    }
	
	

	

}

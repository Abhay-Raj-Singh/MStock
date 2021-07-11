package com.cognizant.mstock.service;

import java.util.List;

import com.cognizant.mstock.entity.Company;
import com.cognizant.mstock.exception.InvalidCompanyException;
import com.cognizant.mstock.exception.UserAlreadyPresentException;

public interface WatchlistService {
	
	public Boolean addCompany(Company company, int user_id) throws UserAlreadyPresentException;
	
	public Boolean deleteCompany(int company_id,int user_id) throws InvalidCompanyException;

	public List<Company> findWatchlist(int user_id) throws UserAlreadyPresentException;

}

package com.cognizant.mstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mstock.dao.WatchlistDao;
import com.cognizant.mstock.entity.Company;
import com.cognizant.mstock.exception.InvalidCompanyException;
import com.cognizant.mstock.exception.UserAlreadyPresentException;

@Service
public class WatchlistServiceImpl implements WatchlistService {
	
	@Autowired
	WatchlistDao watchlistDao;
	
	public Boolean addCompany(Company company,int user_id) throws UserAlreadyPresentException {
		// TODO Auto-generated method stub
		return watchlistDao.addCompany(company,user_id);
	}

	@Override
	public Boolean deleteCompany(int company_id,int user_id) throws InvalidCompanyException {
		// TODO Auto-generated method stub
		return watchlistDao.deleteCompany(company_id, user_id);
	}

	@Override
	public List<Company> findWatchlist(int user_id) throws UserAlreadyPresentException {
		// TODO Auto-generated method stub
		return watchlistDao.findWatchlistById(user_id);
	}

}

package com.cognizant.mstock.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.cognizant.mstock.entity.Company;
import com.cognizant.mstock.exception.InvalidCompanyException;
import com.cognizant.mstock.exception.UserAlreadyPresentException;


@Repository
public class WatchlistDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public Boolean addCompany(Company company,int user_id) throws UserAlreadyPresentException{
		
		
		String sql="insert into watchlist(company_id,user_id) values(?,?); ";
		String check="update watchlist set user_id=?  where  company_id=?";
		int i=jdbcTemplate.update(check,user_id,company.getCompany_id());
		if(i==0) {
			jdbcTemplate.update(sql,company.getCompany_id(),user_id);
		}else {
					// TODO: handle exception
			throw new UserAlreadyPresentException("user already exists");
		}
		
		
		return true;
		
	}


	public Boolean deleteCompany(int company_id,int user_id) throws InvalidCompanyException{
			String sql="delete from watchlist where company_id = ? and user_id=?";
			try {
				jdbcTemplate.update(sql,company_id,user_id);
			} catch (DataIntegrityViolationException e) {
				// TODO: handle exception
				throw new InvalidCompanyException("No Company Found");
			}
			
			return true;
			
		}


	
	public List<Company> findWatchlistById(int user_id) throws UserAlreadyPresentException {
		// TODO Auto-generated method stub
		
		
		List<Company> companyList;
		
		try {
			String findWatchlist="select * from mstock.company inner join watchlist on company.company_id=watchlist.company_id and user_id=?;";
			
			companyList=  jdbcTemplate.query(findWatchlist,new RowMapper<Company>() {
				public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Company tempCompany=new Company();
					tempCompany.setCompany_id(rs.getInt(1));
					tempCompany.setCompany_name(rs.getString(2));
					tempCompany.setCompany_des(rs.getString(3));
					tempCompany.setAvg_price_2019(rs.getInt(4));
					tempCompany.setAvg_price_2020(rs.getInt(5));
					tempCompany.setAvg_price_2021(rs.getInt(6));
					
					
					return tempCompany;
							}
			},user_id);
			
			
			
			
		} catch (DataAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new UserAlreadyPresentException("Watchlist is empty");
		}
		
		return companyList;
		
		
	}


}





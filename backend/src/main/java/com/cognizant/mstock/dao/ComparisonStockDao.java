package com.cognizant.mstock.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.mstock.entity.Company;

@Repository
public interface ComparisonStockDao extends JpaRepository<Company, Serializable>{

	@Query(value ="select company_name from mstock.company where company_name in(?,?)", nativeQuery = true)
	public List<Company> getStockInfo1(String company1 ,String company2);

}

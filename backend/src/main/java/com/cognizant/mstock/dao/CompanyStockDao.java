package com.cognizant.mstock.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.mstock.entity.Company;


@Repository
public interface CompanyStockDao extends JpaRepository<Company, Serializable>{
	
	@Query(value = "SELECT * FROM company ", nativeQuery = true)
	List<Company> findcompany();
	
	
	
	
}




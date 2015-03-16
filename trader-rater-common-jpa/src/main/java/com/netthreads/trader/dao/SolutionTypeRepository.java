package com.netthreads.trader.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.SolutionType;

public interface SolutionTypeRepository extends CrudRepository<SolutionType, Integer> 
{
	@Query("SELECT st FROM "
			+ "SolutionType st "
			+ "WHERE "
			+ "st.title = ?1")
	public SolutionType findByTitle(String title);
}

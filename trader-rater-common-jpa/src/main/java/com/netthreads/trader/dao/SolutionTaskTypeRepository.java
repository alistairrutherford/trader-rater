package com.netthreads.trader.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.SolutionTaskType;
import com.netthreads.trader.domain.SolutionType;

public interface SolutionTaskTypeRepository extends CrudRepository<SolutionTaskType, Integer> 
{
	@Query("SELECT stt FROM "
			+ "SolutionType st, "
			+ "SolutionTaskType stt "
			+ "WHERE "
			+ "stt.owner = st AND "
			+ "st = ?1")
	public Collection<SolutionTaskType> findBySolutionType(SolutionType solutionType);
	
}

package com.netthreads.trader.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.SolutionTaskJobType;
import com.netthreads.trader.domain.SolutionTaskType;

public interface SolutionTaskJobTypeRepository extends CrudRepository<SolutionTaskJobType, Integer> 
{
	@Query("SELECT stjt FROM "
			+ "SolutionTaskType stt, "
			+ "SolutionTaskJobType stjt "
			+ "WHERE "
			+ "stjt.owner = stt AND "
			+ "stt = ?1")
	public Collection<SolutionTaskJobType> findBySolutionTaskType(SolutionTaskType solutionTaskType);

}

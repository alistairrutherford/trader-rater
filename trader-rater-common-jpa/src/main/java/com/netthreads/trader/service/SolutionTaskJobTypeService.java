package com.netthreads.trader.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.SolutionTaskJobTypeRepository;
import com.netthreads.trader.domain.SolutionTaskJobType;
import com.netthreads.trader.domain.SolutionTaskType;

@Repository
@Transactional
public class SolutionTaskJobTypeService
{
	private SolutionTaskJobTypeRepository repository;

	@Autowired
	public SolutionTaskJobTypeService(SolutionTaskJobTypeRepository repository)
	{
		this.repository = repository;
	}

	/**
	 * Find by id.
	 * 
	 * @param id
	 * 
	 * @return The target item.
	 */
	public SolutionTaskJobType findById(int id)
	{
		return repository.findOne(id);
	}
	
	/**
	 * Find all.
	 * 
	 * @return All items.
	 */
	public Iterable<SolutionTaskJobType> findAll()
	{
		return repository.findAll();
	}
	
	/**
	 * Find by SolutionTaskType
	 * 
	 * @param solutionTaskType
	 * 
	 * @return List of items.
	 */
	public Collection<SolutionTaskJobType> findBySolutionTaskType(SolutionTaskType solutionTaskType)
	{
		return repository.findBySolutionTaskType(solutionTaskType);
	}
}

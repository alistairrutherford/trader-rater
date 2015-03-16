package com.netthreads.trader.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.SolutionTaskTypeRepository;
import com.netthreads.trader.domain.SolutionTaskType;
import com.netthreads.trader.domain.SolutionType;

@Repository
@Transactional
public class SolutionTaskTypeService
{
	private SolutionTaskTypeRepository repository;

	@Autowired
	public SolutionTaskTypeService(SolutionTaskTypeRepository repository)
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
	public SolutionTaskType findById(int id)
	{
		return repository.findOne(id);
	}
	
	/**
	 * Find all items.
	 * 
	 * @return The list of items.
	 */
	public Iterable<SolutionTaskType> findAll()
	{
		Iterable<SolutionTaskType> items = repository.findAll();
		
		return items;
	}
	

	/**
	 * Find by Solution Type.
	 * 
	 * @param solutionType
	 * 
	 * @return Iterable list of items.
	 */
	public Collection<SolutionTaskType> findBySolutionType(SolutionType solutionType)
	{
		return repository.findBySolutionType(solutionType);
	}
}

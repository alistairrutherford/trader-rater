package com.netthreads.trader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.SolutionTypeRepository;
import com.netthreads.trader.domain.SolutionType;

@Repository
@Transactional
public class SolutionTypeService
{
	private SolutionTypeRepository repository;

	@Autowired
	public SolutionTypeService(SolutionTypeRepository repository)
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
	public SolutionType findById(int id)
	{
		return repository.findOne(id);
	}
	
	/**
	 * Find all items.
	 * 
	 * @return The list of items.
	 */
	public Iterable<SolutionType> findAll()
	{
		Iterable<SolutionType> items = repository.findAll();
		
		return items;
	}
	
	/**
	 * Search by title.
	 * 
	 * @param title
	 * 
	 * @return The target item.
	 */
	public SolutionType findByTitle(String title)
	{
		return repository.findByTitle(title);
	}
}

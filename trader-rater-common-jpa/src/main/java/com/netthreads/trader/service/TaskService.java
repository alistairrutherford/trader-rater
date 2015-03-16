package com.netthreads.trader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.TaskRepository;
import com.netthreads.trader.domain.Task;
import com.netthreads.trader.exception.DataLayerException;

/**
 * Service.
 * 
 */
@Repository
@Transactional
public class TaskService
{
	private TaskRepository repository;

	@Autowired
	public TaskService(TaskRepository repository)
	{
		this.repository = repository;
	}

	/**
	 * Create item.
	 * 
	 * @param bidState
	 * 
	 * @throws DataLayerException
	 */
	public void create(Task task) throws DataLayerException
	{
		repository.save(task);
	}

	/**
	 * Find all order by state.
	 * 
	 * @return Target list.
	 * @throws DataLayerException
	 */
	public Iterable<Task> findAll() throws DataLayerException
	{
		Iterable<Task> items = repository.findAll();

		return items;
	}
	
	/**
	 * Find by id.
	 * 
	 * @param id
	 * 
	 * @return The target.
	 */
	public Task find(Long id)
	{
		return repository.findOne(id);
	}

}

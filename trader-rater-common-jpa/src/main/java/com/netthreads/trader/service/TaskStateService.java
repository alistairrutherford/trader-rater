package com.netthreads.trader.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.TaskStateRepository;
import com.netthreads.trader.domain.TaskState;
import com.netthreads.trader.domain.TaskState.State;
import com.netthreads.trader.exception.DataLayerException;

/**
 * User Service.
 * 
 */
@Repository
@Transactional
public class TaskStateService
{
	private TaskStateRepository repository;
	
	@Autowired
	public TaskStateService(TaskStateRepository repository)
	{
		this.repository = repository;
	}
	
	/**
	 * Create item.
	 * 
	 * @param taskState
	 * 
	 * @throws DataLayerException
	 */
	public void create(TaskState taskState) throws DataLayerException
	{
		TaskState target = findByState(taskState.getState());
		
		if (target == null)
		{
			repository.save(taskState);
		}
		else
		{
			throw new DataLayerException(Errors.ERROR_TASK_STATE_ALREADY_EXISTS);
		}
	}
	
	/**
	 * Find all.
	 * 
	 * @return Target list.
	 * @throws DataLayerException 
	 */
	public Iterable<TaskState> findAll() throws DataLayerException
	{
		Iterable<TaskState> items = repository.findAll();
		
		return items;
	}
	
	/**
	 * Find by state type.
	 * 
	 * @param userName
	 * 
	 * @return Target user or null if not found.
	 */
	public TaskState findByState(State state)
	{
		TaskState taskState = null;
		
		try
		{
			taskState = repository.findByState(state);
		}
		catch (NoResultException e)
		{
			taskState = null;
		}
		
		return taskState;
	}

	
	/**
	 * Save
	 * 
	 * @param taskState
	 */
	public void save(TaskState taskState)
	{
		repository.save(taskState);
	}

	/**
	 * Delete all.
	 * 
	 */
	public void deleteAll()
	{
		repository.deleteAll();
	}
}

package com.netthreads.trader.service;

import java.util.Collection;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.SolutionRepository;
import com.netthreads.trader.domain.Provider;
import com.netthreads.trader.domain.Solution;
import com.netthreads.trader.exception.DataLayerException;

@Repository
@Transactional
public class SolutionService
{
	private SolutionRepository repository;

	@Autowired
	public SolutionService(SolutionRepository repository)
	{
		this.repository = repository;
	}

	/**
	 * Create item
	 * 
	 * @param service
	 * @throws DataLayerException
	 */
	public void create(Solution service) throws DataLayerException
	{
		if (service == null)
		{
			throw new DataLayerException(Errors.ERROR_NULL_PARAMETER);
		}

		repository.save(service);
	}

	/**
	 * Update service.
	 * 
	 * @param service
	 * @throws DataLayerException
	 */
	public void update(Solution service) throws DataLayerException
	{
		if (service != null)
		{
			repository.save(service);
		}
		else
		{
			throw new DataLayerException(Errors.ERROR_NULL_PARAMETER);
		}
	}

	/**
	 * Delete service.
	 * 
	 * @param service
	 * @throws DataLayerException
	 */
	public void delete(Solution service) throws DataLayerException
	{
		if (service != null)
		{
			repository.delete(service);
		}
		else
		{
			throw new DataLayerException(Errors.ERROR_NULL_PARAMETER);
		}
	}

	/**
	 * Find by title.
	 * 
	 * @param userName
	 * 
	 * @return The target
	 */
	public Solution findByTitle(String userName)
	{
		Solution item = null;

		try
		{
			item = repository.findByTitle(userName);
		}
		catch (NoResultException e)
		{
			item = null;
		}

		return item;
	}

	/**
	 * Find by provider.
	 * 
	 * @param provider
	 * 
	 * @return List of items.
	 */
	public Collection<Solution> findByProvider(Provider provider)
	{
		Collection<Solution> items = null;

		try
		{
			items = repository.findByProvider(provider);
		}
		catch (NoResultException e)
		{
			items = null;
		}

		return items;
	}

	/**
	 * Save
	 * 
	 * @param solution
	 */
	public Solution save(Solution solution)
	{
		return repository.save(solution);
	}

}

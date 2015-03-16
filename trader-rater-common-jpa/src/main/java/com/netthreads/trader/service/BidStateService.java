package com.netthreads.trader.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.BidStateRepository;
import com.netthreads.trader.domain.BidState;
import com.netthreads.trader.domain.BidState.State;
import com.netthreads.trader.exception.DataLayerException;

/**
 * Service.
 * 
 */
@Repository
@Transactional
public class BidStateService
{
	private BidStateRepository repository;

	@Autowired
	public BidStateService(BidStateRepository repository)
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
	public void create(BidState bidState) throws DataLayerException
	{
		BidState target = findByState(bidState.getState());

		if (target == null)
		{
			repository.save(bidState);
		}
		else
		{
			throw new DataLayerException(Errors.ERROR_TASK_STATE_ALREADY_EXISTS);
		}
	}

	/**
	 * Find all order by state.
	 * 
	 * @return Target list.
	 * @throws DataLayerException
	 */
	public Iterable<BidState> findAll() throws DataLayerException
	{
		Iterable<BidState> items = repository.findAll();

		return items;
	}

	/**
	 * Find by state type.
	 * 
	 * @param userName
	 * 
	 * @return Target user or null if not found.
	 */
	public BidState findByState(State state)
	{
		BidState bidState = null;

		try
		{
			bidState = repository.findByState(state);
		}
		catch (NoResultException e)
		{
			bidState = null;
		}

		return bidState;
	}

}

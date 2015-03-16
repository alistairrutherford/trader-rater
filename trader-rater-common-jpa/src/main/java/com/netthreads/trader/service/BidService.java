package com.netthreads.trader.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.BidRepository;
import com.netthreads.trader.domain.Bid;
import com.netthreads.trader.exception.DataLayerException;

/**
 * Service.
 * 
 */
@Repository
@Transactional
public class BidService
{
	private BidRepository repository;

	@Autowired
	public BidService(BidRepository repository)
	{
		this.repository = repository;
	}

	/**
	 * Create item.
	 * 
	 * @param bid
	 * 
	 * @throws DataLayerException
	 */
	public void create(Bid bid) throws DataLayerException
	{
		bid.setCreated(new Date());
		
		repository.save(bid);
	}

	/**
	 * Find all order by state.
	 * 
	 * @return Target list.
	 * @throws DataLayerException
	 */
	public Iterable<Bid> findAll() throws DataLayerException
	{
		Iterable<Bid> items = repository.findAll();

		return items;
	}
	
}

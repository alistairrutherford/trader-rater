package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.BidState;
import com.netthreads.trader.domain.BidState.State;

public interface BidStateRepository extends CrudRepository<BidState, Serializable> 
{
	public final static String QUERY_FIND_BY_STATE = "SELECT s FROM BidState s WHERE s.state = ?1";

	@Query(QUERY_FIND_BY_STATE)
	public BidState findByState(State state);
}

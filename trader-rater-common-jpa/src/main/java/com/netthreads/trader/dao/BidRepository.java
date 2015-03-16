package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.Bid;

public interface BidRepository extends CrudRepository<Bid, Serializable> 
{

}

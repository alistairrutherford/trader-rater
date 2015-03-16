package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Serializable> 
{
	public final static String QUERY_FIND_BY_USER_NAME = "SELECT p FROM Provider p WHERE LOWER(p.userDetails.userName) = ?1";

	@Query(QUERY_FIND_BY_USER_NAME)
	public Provider findByName(String userName);
}

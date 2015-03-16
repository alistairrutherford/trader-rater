package com.netthreads.trader.dao;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.Provider;
import com.netthreads.trader.domain.Solution;

public interface SolutionRepository extends CrudRepository<Solution, Serializable>
{
	public final static String QUERY_FIND_BY_TITLE = "SELECT s FROM Solution s, Provider p WHERE s.owner = p AND LOWER(p.title) = ?1";
	public final static String QUERY_FIND_BY_PROVIDER = "SELECT s FROM Solution s WHERE s.owner = ?1";

	@Query(QUERY_FIND_BY_TITLE)
	public Solution findByTitle(String userName);

	@Query(QUERY_FIND_BY_PROVIDER)
	public Collection<Solution> findByProvider(Provider provider);	
}


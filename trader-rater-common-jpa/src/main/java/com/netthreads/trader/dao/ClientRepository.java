package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Serializable>
{
	public final static String QUERY_FIND_BY_USER_NAME = "SELECT c FROM Client c WHERE LOWER(c.userDetails.userName) = ?1";

	@Query(QUERY_FIND_BY_USER_NAME)
	public Client findByName(String userName);
}

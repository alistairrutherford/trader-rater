package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Serializable> 
{
	public final static String QUERY_FIND_BY_USER_NAME = "SELECT u FROM UserDetails u WHERE LOWER(u.userName) = ?1";

	@Query(QUERY_FIND_BY_USER_NAME)
	public UserDetails findByUserName(String userName);
}

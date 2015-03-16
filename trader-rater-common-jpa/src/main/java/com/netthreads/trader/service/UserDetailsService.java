package com.netthreads.trader.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.UserDetailsRepository;
import com.netthreads.trader.domain.UserDetails;

/**
 * User Service.
 * 
 */
@Repository
@Transactional
public class UserDetailsService
{
	private UserDetailsRepository repository;

	@Autowired
	public UserDetailsService(UserDetailsRepository repository)
	{
		this.repository = repository;
	}

	/**
	 * Find user
	 * 
	 * @param userName
	 * 
	 * @return Target user or null if not found.
	 */
	public UserDetails findByUserName(String userName)
	{
		UserDetails user = null;

		try
		{
			user = repository.findByUserName(userName);
		}
		catch (NoResultException e)
		{
			user = null;
		}

		return user;
	}

}

package com.netthreads.trader.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.ProviderRepository;
import com.netthreads.trader.domain.Provider;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;

@Repository
@Transactional
public class ProviderService
{
	private UserDetailsService userService;

	private ProviderRepository repository;

	@Autowired
	public ProviderService(UserDetailsService userService, ProviderRepository repository)
	{
		this.userService = userService;

		this.repository = repository;
	}

	/**
	 * Find provider by user name.
	 * 
	 * @param userName
	 * 
	 * @return The target provider.
	 */
	public Provider findByName(String userName)
	{
		Provider provider = null;
		try
		{
			provider = repository.findByName(userName);
		}
		catch (NoResultException e)
		{
			provider = null;
		}

		return provider;
	}

	/**
	 * Create a provider.
	 * 
	 * Note: Associated user must be set.
	 * 
	 * @param provider
	 *            Populated provider object.
	 * @param user
	 *            Populated user object.
	 * 
	 * @throws DataLayerException
	 */
	public void create(Provider provider) throws DataLayerException
	{
		UserDetails providerUser = provider.getUserDetails();

		// Create must have a an associated UserDetails.
		if (providerUser != null)
		{
			// Look for existing user.
			UserDetails targetUser = userService.findByUserName(providerUser.getUserName());

			// Should be no existing user associated with provider.
			if (targetUser == null)
			{
				repository.save(provider);
			}
			else
			{
				throw new DataLayerException(Errors.ERROR_USER_ALREADY_EXISTS);
			}
		}
		else
		{
			throw new DataLayerException(Errors.ERROR_NO_USER_ASSOCIATED_WITH_CLIENT);
		}
	}

	/**
	 * Update provider.
	 * 
	 * @param provider
	 * @throws DataLayerException
	 */
	public void update(Provider provider) throws DataLayerException
	{
		UserDetails providerUser = provider.getUserDetails();

		if (providerUser != null)
		{
			repository.save(provider);
		}
		else
		{
			throw new DataLayerException(Errors.ERROR_NO_USER_ASSOCIATED_WITH_CLIENT);
		}
	}

	/**
	 * Delete provider.
	 * 
	 * @param provider
	 * @throws DataLayerException
	 */
	public void delete(Provider provider) throws DataLayerException
	{
		repository.delete(provider);
	}

}

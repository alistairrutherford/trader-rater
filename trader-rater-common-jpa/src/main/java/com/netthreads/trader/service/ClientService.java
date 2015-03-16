package com.netthreads.trader.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.dao.ClientRepository;
import com.netthreads.trader.domain.Client;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;

/**
 * Client Service.
 *
 */
@Repository
@Transactional
public class ClientService
{
	private UserDetailsService userService;

	private ClientRepository repository;

	/**
	 * Construct service.
	 * 
	 * @param userService
	 * @param repository
	 */
	@Autowired
	public ClientService(UserDetailsService userService, ClientRepository repository)
	{
		this.userService = userService;
		this.repository = repository;
	}

	public Iterable<Client> findAll()
	{
		return repository.findAll();
	}

	/**
	 * Find client by user name.
	 * 
	 * @param userName
	 * 
	 * @return The target client.
	 */
	public Client findByName(String userName)
	{
		Client client = null;

		try
		{
			client = repository.findByName(userName);
		}
		catch (NoResultException e)
		{
			client = null;
		}

		return client;
	}

	/**
	 * Create a client.
	 * 
	 * Note: Associated user must be set.
	 * 
	 * @param client
	 *            Populated client object.
	 * @param user
	 *            Populated user object.
	 * 
	 * @throws DataLayerException
	 */
	public void create(Client client) throws DataLayerException
	{
		UserDetails clientUser = client.getUserDetails();

		// Create must have a an associated UserDetails.
		if (clientUser != null)
		{
			// Look for existing user.
			UserDetails targetUser = userService.findByUserName(clientUser.getUserName());

			// Should be no existing user associated with client.
			if (targetUser == null)
			{
				repository.save(client);
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
	 * Update client.
	 * 
	 * @param client
	 * @throws DataLayerException
	 */
	public Client update(Client client) throws DataLayerException
	{
		UserDetails clientUser = client.getUserDetails();

		if (clientUser != null)
		{
			client = repository.save(client);
		}
		else
		{
			throw new DataLayerException(Errors.ERROR_NO_USER_ASSOCIATED_WITH_CLIENT);
		}

		return client;
	}

	/**
	 * Delete client.
	 * 
	 * @param client
	 * @throws DataLayerException
	 */
	public void delete(Client client) throws DataLayerException
	{
		repository.delete(client);
	}

}

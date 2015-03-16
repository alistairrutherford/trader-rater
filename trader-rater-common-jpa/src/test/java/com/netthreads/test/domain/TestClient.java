package com.netthreads.test.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netthreads.test.helper.CreateHelper;
import com.netthreads.test.system.PersistenceConfiguration;
import com.netthreads.trader.domain.Client;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;
import com.netthreads.trader.service.ClientService;
import com.netthreads.trader.service.UserDetailsService;

/**
 * Test
 * 
 * @author Alistair
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(classes =
{
		PersistenceConfiguration.class
})
public class TestClient
{
	private static final Logger LOG = LoggerFactory.getLogger(TestClient.class);

	private static int TEST_INDEX = 1;
	
	@Autowired
	private CreateHelper createHelper;

	@Autowired
	private ClientService clientService;

	@Autowired
	private UserDetailsService userService;

	@Before
	public void before() throws DataLayerException
	{
		LOG.info("Build injector");
		
		populate();
	}

	@After
	public void after() throws DataLayerException
	{
		depopulate();
	}

	private void populate() throws DataLayerException
	{
		UserDetails userDetails = createHelper.createUserDetails(TEST_INDEX);

		// Client user
		Client client = new Client();
		client.setUserDetails(userDetails);

		// Client service.
		clientService.create(client);
	}
	
	
	private void depopulate() throws DataLayerException
	{
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));
		
		if (client!=null)
		{
			clientService.delete(client);
		}
	}
	
	
	/**
	 * Write.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testRead() throws DataLayerException
	{
		Client readBackClient = clientService.findByName(createHelper.createUserName(TEST_INDEX));
		
		org.junit.Assert.assertNotNull(readBackClient);
		
		org.junit.Assert.assertNotNull(readBackClient.getUserDetails());
	}

	/**
	 * Update
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testUpdate() throws DataLayerException
	{
		// Update
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		org.junit.Assert.assertNotNull(client);

		org.junit.Assert.assertNotNull(client.getUserDetails());

		client.getUserDetails().setAddress(CreateHelper.USER_DETAILS_ADDRESS);
		client.getUserDetails().setMobilePhone(CreateHelper.USER_DETAILS_MOBILE_PHONE);

		clientService.update(client);

		// Read back
		Client readbackClient = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		org.junit.Assert.assertNotNull(readbackClient);

		UserDetails userDetails = readbackClient.getUserDetails();

		org.junit.Assert.assertNotNull(userDetails.getAddress().equals(CreateHelper.USER_DETAILS_ADDRESS));

		org.junit.Assert.assertNotNull(userDetails.getMobilePhone().equals(CreateHelper.USER_DETAILS_MOBILE_PHONE));
	}

	/**
	 * Update
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testDelete() throws DataLayerException
	{
		// Update
		String testUser = createHelper.createUserName(TEST_INDEX);
				
		Client client = clientService.findByName(testUser);

		org.junit.Assert.assertNotNull(client);

		org.junit.Assert.assertNotNull(client.getUserDetails());

		clientService.delete(client);

		client = clientService.findByName(testUser);

		org.junit.Assert.assertTrue(client == null);

		UserDetails userDetails = userService.findByUserName(testUser);

		org.junit.Assert.assertTrue(userDetails == null);

	}

}

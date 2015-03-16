package com.netthreads.test.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netthreads.test.helper.CreateHelper;
import com.netthreads.test.system.PersistenceConfiguration;
import com.netthreads.trader.domain.Provider;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;
import com.netthreads.trader.service.ProviderService;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProvider
{
	private static final Logger LOG = LoggerFactory.getLogger(TestProvider.class);
	
	private static int TEST_INDEX = 2;
	
	@Autowired
	private CreateHelper createHelper;
	
	@Autowired
	private ProviderService providerService;
	
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
	
	/**
	 * Read.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testRead() throws DataLayerException
	{
		Provider readBackProvider = providerService.findByName(createHelper.createUserName(TEST_INDEX));
		
		org.junit.Assert.assertNotNull(readBackProvider);
		
		org.junit.Assert.assertNotNull(readBackProvider.getUserDetails());
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
		Provider provider = providerService.findByName(createHelper.createUserName(TEST_INDEX));
		
		org.junit.Assert.assertNotNull(provider);
		
		org.junit.Assert.assertNotNull(provider.getUserDetails());
		
		provider.getUserDetails().setAddress(CreateHelper.USER_DETAILS_ADDRESS);
		provider.getUserDetails().setMobilePhone(CreateHelper.USER_DETAILS_MOBILE_PHONE);
		
		providerService.update(provider);
		
		// Read back
		Provider readbackProvider = providerService.findByName(createHelper.createUserName(TEST_INDEX));
		
		org.junit.Assert.assertNotNull(readbackProvider);
		
		UserDetails userDetails = readbackProvider.getUserDetails();
		
		org.junit.Assert.assertNotNull(userDetails.getAddress().equals(CreateHelper.USER_DETAILS_ADDRESS));
		
		org.junit.Assert.assertNotNull(userDetails.getMobilePhone().equals(CreateHelper.USER_DETAILS_MOBILE_PHONE));
	}
	
	/**
	 * Delete
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testDelete() throws DataLayerException
	{
		// Update
		Provider provider = providerService.findByName(createHelper.createUserName(TEST_INDEX));
		
		org.junit.Assert.assertNotNull(provider);
		
		org.junit.Assert.assertNotNull(provider.getUserDetails());
		
		providerService.delete(provider);
		
		provider = providerService.findByName(createHelper.createUserName(TEST_INDEX));
		
		org.junit.Assert.assertTrue(provider == null);
		
		UserDetails userDetails = userService.findByUserName(createHelper.createUserName(TEST_INDEX));
		
		org.junit.Assert.assertTrue(userDetails == null);
		
	}
	
	private void populate() throws DataLayerException
	{
		// User
		UserDetails userDetails = createHelper.createUserDetails(TEST_INDEX);
		
		// Provider user
		Provider provider = createHelper.createProvider(TEST_INDEX);
		provider.setUserDetails(userDetails);
		
		// Provider service.
		providerService.create(provider);
		
	}
	
	
	private void depopulate() throws DataLayerException
	{
		Provider provider = providerService.findByName(createHelper.createUserName(TEST_INDEX));
		
		if (provider!=null)
		{
			providerService.delete(provider);
		}
	}
}

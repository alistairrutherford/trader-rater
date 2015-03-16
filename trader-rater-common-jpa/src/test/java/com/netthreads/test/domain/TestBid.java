package com.netthreads.test.domain;

import java.math.BigDecimal;
import java.util.List;

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
import com.netthreads.test.helper.StaticDataHelper;
import com.netthreads.test.system.PersistenceConfiguration;
import com.netthreads.trader.domain.Bid;
import com.netthreads.trader.domain.BidState;
import com.netthreads.trader.domain.BidState.State;
import com.netthreads.trader.domain.Provider;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;
import com.netthreads.trader.service.BidStateService;
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
public class TestBid
{
	private static final Logger LOG = LoggerFactory.getLogger(TestBid.class);

	private static int TEST_INDEX = 2;
	private static double TEST_BID_A = 10.0;
	private static double TEST_BID_B = 20.0;


	@Autowired
	private CreateHelper createHelper;

	@Autowired
	private StaticDataHelper staticDataHelper;

	@Autowired
	private ProviderService providerService;

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private BidStateService bidStateService;

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
	 * Write.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testWrite() throws DataLayerException
	{
		Provider provider = providerService.findByName(createHelper.createUserName(TEST_INDEX));

		Bid bid = createHelper.createBid();
		bid.setValue(new BigDecimal(TEST_BID_A));
		BidState bidState = bidStateService.findByState(BidState.State.UNPUBLISHED);
		bid.setBidState(bidState);
		bid.setOwner(provider);

		provider.getBids().add(bid);

		providerService.update(provider);

		Provider readBackPovider = providerService.findByName(createHelper.createUserName(TEST_INDEX));

		Bid readBackBid = readBackPovider.getBids().get(0);

		org.junit.Assert.assertNotNull(readBackBid);

		// Check it has been associated with provider.
		org.junit.Assert.assertTrue(readBackBid.getId() != 0);
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
		Bid bid = createHelper.createBid();
		bid.setValue(new BigDecimal(TEST_BID_A));
		BidState bidState = bidStateService.findByState(State.UNPUBLISHED);
		bid.setBidState(bidState);
		bid.setOwner(provider);
		provider.getBids().add(bid);
		providerService.update(provider);

		Provider readBackProvider = providerService.findByName(createHelper.createUserName(TEST_INDEX));

		List<Bid> bids = readBackProvider.getBids();

		for (Bid readBackBid : bids)
		{
			readBackBid.setValue(new BigDecimal(TEST_BID_B));
			readBackBid.setBidState(bidStateService.findByState(State.PUBLISHED));
		}

		providerService.update(readBackProvider);

		// Read back and verify
		readBackProvider = providerService.findByName(createHelper.createUserName(TEST_INDEX));

		List<Bid> readBackBids = readBackProvider.getBids();

		for (Bid readBackBid : readBackBids)
		{
			org.junit.Assert.assertTrue(readBackBid.getValue().doubleValue() == TEST_BID_B);
			
			org.junit.Assert.assertTrue(readBackBid.getBidState().getState().equals(State.PUBLISHED));
		}

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

		staticDataHelper.createBidStateData();
	}

	private void depopulate() throws DataLayerException
	{
		Provider provider = providerService.findByName(createHelper.createUserName(TEST_INDEX));

		if (provider != null)
		{
			providerService.delete(provider);
		}

		staticDataHelper.deleteBidStateData();
	}

}

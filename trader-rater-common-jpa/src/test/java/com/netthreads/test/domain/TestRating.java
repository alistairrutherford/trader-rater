package com.netthreads.test.domain;

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
import com.netthreads.test.system.PersistenceConfiguration;
import com.netthreads.trader.dao.RatingRepository;
import com.netthreads.trader.domain.Client;
import com.netthreads.trader.domain.Rating;
import com.netthreads.trader.domain.Task;
import com.netthreads.trader.domain.TaskState.State;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;
import com.netthreads.trader.service.ClientService;
import com.netthreads.trader.service.TaskStateService;

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
public class TestRating
{
	private static final Logger LOG = LoggerFactory.getLogger(TestRating.class);

	private static int TEST_INDEX = 5;

	@Autowired
	private CreateHelper createHelper;

	@Autowired
	private ClientService clientService;

	@Autowired
	private TaskStateService taskStateService;

	@Autowired
	private RatingRepository ratingRepository;

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
	 * Ratings are created against Clients.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testWrite() throws DataLayerException
	{
		// Client
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		// Client associated task
		Task task = createHelper.createTask(TEST_INDEX);
		task.setTaskState(taskStateService.findByState(State.UNPUBLISHED));
		client.getTasks().add(task);
		task.setOwner(client);

		// Client associated rating
		Rating rating = createHelper.createRating(TEST_INDEX);
		rating.setTask(task);
		client.getRatings().add(rating);
		rating.setOwner(client);

		clientService.update(client);

		// Read back and check rating list size.
		Client readBackClient = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		org.junit.Assert.assertTrue(readBackClient.getRatings().size() == 1);
	}

	/**
	 * Read.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testRead()
	{
		// Client
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		for (Rating rating : client.getRatings())
		{
			Rating readBackRating = ratingRepository.findOne(rating.getId());

			org.junit.Assert.assertNotNull(readBackRating);
		}
	}

	/**
	 * Update
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testUpdate() throws DataLayerException
	{
		// Client
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		for (Rating rating : client.getRatings())
		{
			Rating readBackRating = ratingRepository.findOne(rating.getId());
			readBackRating.setScore(1000);

			ratingRepository.save(readBackRating);
		}

		Client updatedClient = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		for (Rating rating : updatedClient.getRatings())
		{
			Rating readBackRating = ratingRepository.findOne(rating.getId());

			org.junit.Assert.assertNotNull(readBackRating.getScore() == 1000);
		}

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
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		client.getRatings().clear();

		clientService.update(client);

		List<Rating> ratings = (List<Rating>) ratingRepository.findAll();

		org.junit.Assert.assertTrue(ratings.isEmpty());
	}

	/**
	 * Populate test data.
	 * 
	 * @throws DataLayerException
	 */
	private void populate() throws DataLayerException
	{
		// ---------------------------------------------------------------
		// User
		// ---------------------------------------------------------------
		UserDetails userDetails = createHelper.createUserDetails(TEST_INDEX);

		// ---------------------------------------------------------------
		// Client user
		// ---------------------------------------------------------------
		Client client = new Client();
		client.setUserDetails(userDetails);

		// Client service.
		clientService.create(client);
	}

	/**
	 * Depopulate test data.
	 * 
	 * @throws DataLayerException
	 */
	public void depopulate() throws DataLayerException
	{
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		clientService.delete(client);
	}
}

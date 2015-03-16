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
import com.netthreads.test.helper.StaticDataHelper;
import com.netthreads.test.system.PersistenceConfiguration;
import com.netthreads.trader.domain.Client;
import com.netthreads.trader.domain.Task;
import com.netthreads.trader.domain.TaskState;
import com.netthreads.trader.domain.TaskState.State;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;
import com.netthreads.trader.service.ClientService;
import com.netthreads.trader.service.TaskService;
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
public class TestTask
{
	private static final Logger LOG = LoggerFactory.getLogger(TestTask.class);

	private static int TEST_INDEX = 5;

	@Autowired
	private CreateHelper createHelper;

	@Autowired
	private StaticDataHelper staticDataHelper;

	@Autowired
	private TaskStateService taskStateService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private TaskService taskService;

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
	 * Tasks are created against Clients.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testWriteRead() throws DataLayerException
	{
		// Client
		Client client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		// Client associated task
		Task task = createHelper.createTask(TEST_INDEX);
		task.setTaskState(taskStateService.findByState(State.UNPUBLISHED));
		task.setOwner(client);
		client.getTasks().add(task);

		clientService.update(client);

		// Read back and check task list size.
		Client readBackClient = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		Task readBackTask = readBackClient.getTasks().get(0);

		org.junit.Assert.assertTrue(readBackTask.getId() != null);
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

		for (int i = 0; i < 10; i++)
		{
			// Client associated task
			Task task = createHelper.createTask(TEST_INDEX + i);
			task.setTaskState(taskStateService.findByState(State.UNPUBLISHED));
			task.setOwner(client);
			client.getTasks().add(task);
		}
		// Update
		clientService.update(client);

		client = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		for (Task task : client.getTasks())
		{
			TaskState taskState = taskStateService.findByState(State.PUBLISHED);
			task.setTaskState(taskState);
		}

		// Update all tasks.
		clientService.update(client);

		Client updatedClient = clientService.findByName(createHelper.createUserName(TEST_INDEX));

		for (Task task : updatedClient.getTasks())
		{
			Task readBackTask = taskService.find(task.getId());

			org.junit.Assert.assertNotNull(readBackTask.getTaskState().getState().equals(State.PUBLISHED));
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

		client.getTasks().clear();

		clientService.update(client);

		Iterable<Task> tasks = taskService.findAll();

		org.junit.Assert.assertTrue(!tasks.iterator().hasNext());
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

		// Task State Static
		staticDataHelper.createTaskStateData();
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

		// Delete Task State Static
		staticDataHelper.deleteTaskStateData();
	}
}

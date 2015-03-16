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
import com.netthreads.trader.domain.TaskState;
import com.netthreads.trader.exception.DataLayerException;
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
public class TestTaskState
{
	private static final Logger LOG = LoggerFactory.getLogger(TestTaskState.class);

	private static int TEST_INDEX = 6;

	@Autowired
	private CreateHelper createHelper;

	@Autowired
	private TaskStateService taskStateService;

	@Before
	public void before() throws DataLayerException
	{
		LOG.info("Build injector");
	}

	@After
	public void after()
	{

	}

	/**
	 * Tasks are created against Clients.
	 * 
	 * @throws DataLayerException
	 */
	@Test
	public void testWriteRead() throws DataLayerException
	{
		// ---------------------------------------------------------------
		// Task States
		// ---------------------------------------------------------------
		for (TaskState.State state : TaskState.State.values())
		{
			TaskState taskState = createHelper.createTaskState(TEST_INDEX);
			taskState.setState(state);
			taskStateService.save(taskState);
		}

		// ---------------------------------------------------------------
		// Task States
		// ---------------------------------------------------------------
		Iterable<TaskState> readBackStates = taskStateService.findAll();

		for (TaskState taskState : readBackStates)
		{
			Long id = taskState.getId();

			org.junit.Assert.assertNotNull(id);

			org.junit.Assert.assertTrue(id != 0);
		}

		// ---------------------------------------------------------------
		// Delete
		// ---------------------------------------------------------------
		taskStateService.deleteAll();

		readBackStates = taskStateService.findAll();

		org.junit.Assert.assertTrue(!readBackStates.iterator().hasNext());
	}

}

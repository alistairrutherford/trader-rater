package com.netthreads.test.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netthreads.trader.dao.BidStateRepository;
import com.netthreads.trader.dao.RoleRepository;
import com.netthreads.trader.dao.TaskStateRepository;
import com.netthreads.trader.domain.BidState;
import com.netthreads.trader.domain.Role;
import com.netthreads.trader.domain.TaskState;
import com.netthreads.trader.domain.TaskState.State;
import com.netthreads.trader.exception.DataLayerException;

/**
 * Test
 * 
 * @author Alistair
 * 
 */
@Component
public class StaticDataHelper
{
	private static final Logger LOG = LoggerFactory.getLogger(StaticDataHelper.class);

	@Autowired
	private CreateHelper createHelper;

	@Autowired
	private TaskStateRepository taskStateDao;

	@Autowired
	private RoleRepository roleDao;

	@Autowired
	private BidStateRepository bidStateDao;

	/**
	 * Create static TaskState data.
	 * 
	 * @throws DataLayerException
	 */
	public void createTaskStateData() throws DataLayerException
	{
		// ---------------------------------------------------------------
		// Task States
		// ---------------------------------------------------------------
		State[] values = TaskState.State.values();
		for (TaskState.State state : values)
		{
			TaskState taskState = createHelper.createTaskState(0);
			taskState.setState(state);
			taskStateDao.save(taskState);

			LOG.info(taskState.toString());
		}
	}

	/**
	 * Delete all TaskState data.
	 * 
	 * @throws DataLayerException
	 */
	public void deleteTaskStateData() throws DataLayerException
	{
		taskStateDao.deleteAll();
	}

	// ----------------

	/**
	 * Create static Role data.
	 * 
	 * @throws DataLayerException
	 */
	public void createRoleData() throws DataLayerException
	{
		// ---------------------------------------------------------------
		// Task States
		// ---------------------------------------------------------------
		for (Role.RoleType roleType : Role.RoleType.values())
		{
			Role role = createHelper.createRole(0);
			role.setRoleType(roleType);
			roleDao.save(role);
		}
	}

	/**
	 * Delete all Role data.
	 * 
	 * @throws DataLayerException
	 */
	public void deleteRoleData() throws DataLayerException
	{
		roleDao.deleteAll();
	}

	// ----------------

	/**
	 * Create static BidState data.
	 * 
	 * @throws DataLayerException
	 */
	public void createBidStateData() throws DataLayerException
	{
		// ---------------------------------------------------------------
		// Task States
		// ---------------------------------------------------------------
		for (BidState.State state : BidState.State.values())
		{
			BidState bidState = createHelper.createBidState(0);
			bidState.setState(state);
			bidStateDao.save(bidState);
		}
	}

	/**
	 * Delete all BidState data.
	 * 
	 * @throws DataLayerException
	 */
	public void deleteBidStateData() throws DataLayerException
	{
		bidStateDao.deleteAll();
	}

}

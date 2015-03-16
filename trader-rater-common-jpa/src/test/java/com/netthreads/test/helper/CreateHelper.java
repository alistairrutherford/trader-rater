package com.netthreads.test.helper;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.netthreads.trader.domain.Bid;
import com.netthreads.trader.domain.BidState;
import com.netthreads.trader.domain.Client;
import com.netthreads.trader.domain.Provider;
import com.netthreads.trader.domain.Rating;
import com.netthreads.trader.domain.Role;
import com.netthreads.trader.domain.Role.RoleType;
import com.netthreads.trader.domain.Solution;
import com.netthreads.trader.domain.SolutionTaskJobType;
import com.netthreads.trader.domain.SolutionTaskType;
import com.netthreads.trader.domain.SolutionType;
import com.netthreads.trader.domain.Task;
import com.netthreads.trader.domain.TaskState;
import com.netthreads.trader.domain.TaskState.State;
import com.netthreads.trader.domain.TaskType;
import com.netthreads.trader.domain.UserDetails;
import com.netthreads.trader.exception.DataLayerException;

@Component
@Transactional
public class CreateHelper
{
	public static final String USER_DETAILS_NAME = "user_details_user_name";
	public static final String USER_DETAILS_FIRST_NAME = "user_details_first_name";
	public static final String USER_DETAILS_LAST_NAME = "user_details_last_name";
	public static final String USER_DETAILS_ADDRESS = "user_details_address";
	public static final String USER_DETAILS_POST_CODE = "user_details_post_code";
	public static final String USER_DETAILS_PHONE = "user_details_phone";
	public static final String USER_DETAILS_MOBILE_PHONE = "user_details_mobile_phone";

	public static final String ROLE_TITLE = "role_title";

	public static final String PROVIDER_PHONE = "provider_phone";
	public static final String PROVIDER_MOBILE_PHONE = "provider_mobile_phone";

	public static final String SERVICE_DETAILS_DESCRIPTION = "service_details_description";

	public static final String TASK_TYPE_TITLE = "task_type_title";
	public static final String TASK_TYPE_DESCRIPTION = "task_type_description";

	public static final String TASK_POST_CODE = "task_post_code";

	public static final String TASK_STATE_TITLE = "task_state_title";
	public static final String TASK_STATE_DESCRIPTION = "task_state_description";

	public static final String SERVICE_TYPE_TITLE = "service_type_title";
	public static final String SERVICE_TYPE_DESCRIPTION = "service_type_description";

	public static final String RATING_SHORT_DESCRIPTION = "rating_short_description";
	public static final String RATING_LONG_DESCRIPTION = "rating_long_description";

	/**
	 * Create test client.
	 * 
	 * @return Test provider
	 * 
	 * @throws DataLayerException
	 */
	public Client createClient(int index) throws DataLayerException
	{
		Client client = new Client();

		return client;
	}

	/**
	 * Create test provider.
	 * 
	 * @param index
	 * 
	 * @return target
	 */
	public Provider createProvider(int index)
	{
		Provider provider = new Provider();

		return provider;
	}

	/**
	 * Create Service Details
	 * 
	 * @return ServiceDetails
	 * 
	 * @throws DataLayerException
	 */
	public Solution createService(int index)
	{
		Solution serviceDetails = new Solution();
		serviceDetails.setDescription(SERVICE_DETAILS_DESCRIPTION + index);

		return serviceDetails;
	}

	/**
	 * Create test role.
	 * 
	 * @param index
	 * 
	 * @return target
	 */
	public Role createRole(int index)
	{
		// Role
		Role role = new Role();
		role.setTitle(ROLE_TITLE + index);
		role.setRoleType(RoleType.PROVIDER);

		return role;
	}

	/**
	 * Create test user details
	 * 
	 * @param index
	 * 
	 * @return target
	 */
	public UserDetails createUserDetails(int index)
	{
		// User
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(createUserName(index));
		userDetails.setFirstName(USER_DETAILS_FIRST_NAME + index);
		userDetails.setLastName(USER_DETAILS_LAST_NAME + index);
		userDetails.setAddress(USER_DETAILS_ADDRESS + index);
		userDetails.setPostCode(USER_DETAILS_POST_CODE + index);
		userDetails.setPhone(USER_DETAILS_PHONE + index);
		userDetails.setMobilePhone(USER_DETAILS_MOBILE_PHONE + index);

		return userDetails;
	}

	/**
	 * Create test Task
	 * 
	 * @param index
	 * 
	 * @return target
	 */
	public Task createTask(int index)
	{
		// Static type
		Task task = new Task();
		task.setPostCode(TASK_POST_CODE + index);
		task.setCreated(new Date());

		return task;
	}

	/**
	 * Create test Task state
	 * 
	 * @param index
	 * 
	 * @return target
	 */
	public TaskState createTaskState(int index)
	{
		// Static type
		TaskState taskState = new TaskState();
		taskState.setTitle(TASK_STATE_TITLE + index);
		taskState.setDescription(TASK_STATE_DESCRIPTION + index);
		taskState.setState(State.UNPUBLISHED);

		return taskState;
	}

	/**
	 * Create test Task Type
	 * 
	 * @param index
	 * 
	 * @return target
	 */
	public TaskType createTaskType(int index)
	{
		// Static type
		TaskType taskType = new TaskType();
		taskType.setTitle(TASK_TYPE_TITLE + index);
		taskType.setDescription(TASK_TYPE_DESCRIPTION + index);

		return taskType;
	}

	/**
	 * Create test Service Type
	 * 
	 * @param index
	 * 
	 * @return target
	 */
	public SolutionType createServiceType(int index)
	{

		// Static type
		SolutionType serviceType = new SolutionType();
		serviceType.setTitle(SERVICE_TYPE_TITLE + index);
		serviceType.setDescription(SERVICE_TYPE_DESCRIPTION + index);

		return serviceType;
	}

	/**
	 * Create Service Task
	 * 
	 * @return ServiceTask
	 * 
	 * @throws DataLayerException
	 */
	public SolutionTaskType createServiceTaskType(int index)
	{
		// Static type
		SolutionTaskType serviceTaskType = new SolutionTaskType();

		return serviceTaskType;
	}

	/**
	 * Create Service Task
	 * 
	 * @return ServiceTask
	 * 
	 * @throws DataLayerException
	 */
	public SolutionTaskJobType createServiceTaskJobType(int index)
	{
		// Static type
		SolutionTaskJobType serviceTaskJobType = new SolutionTaskJobType();

		return serviceTaskJobType;
	}
	
	/**
	 * Create Bid 
	 * 
	 * @return ServiceTask
	 * 
	 * @throws DataLayerException
	 */
	public Bid createBid()
	{
		// Static type
		Bid bid = new Bid();
		bid.setCreated(new Date());

		return bid;
	}
	
	/**
	 * Create Bid State
	 * 
	 * @return BidState 
	 * 
	 * @throws DataLayerException
	 */
	public BidState createBidState(int index)
	{
		// Static type
		BidState bidState = new BidState();

		return bidState;
	}

	/**
	 * Create Rating
	 * 
	 * @return Rating
	 * 
	 * @throws DataLayerException
	 */
	public Rating createRating(int index)
	{
		Rating rating = new Rating();
		rating.setShortDescription(RATING_SHORT_DESCRIPTION + index);
		rating.setLongDescription(RATING_LONG_DESCRIPTION + index);
		rating.setScore(index);

		return rating;
	}

	public String createUserName(int index)
	{
		return USER_DETAILS_NAME + index;
	}

}

package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.TaskState;
import com.netthreads.trader.domain.TaskState.State;

public interface TaskStateRepository extends CrudRepository<TaskState, Serializable>
{
	public final static String QUERY_FIND_BY_STATE = "SELECT ts FROM TaskState ts WHERE ts.state = ?1";

	@Query(QUERY_FIND_BY_STATE)
	public TaskState findByState(State state);
}

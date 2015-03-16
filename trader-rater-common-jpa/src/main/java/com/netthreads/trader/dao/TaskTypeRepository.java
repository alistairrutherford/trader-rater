package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.TaskType;

public interface TaskTypeRepository extends CrudRepository<TaskType, Serializable> 
{

}

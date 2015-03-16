package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Serializable> 
{

}

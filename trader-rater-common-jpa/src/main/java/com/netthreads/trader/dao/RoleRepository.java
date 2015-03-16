package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Serializable> 
{

}

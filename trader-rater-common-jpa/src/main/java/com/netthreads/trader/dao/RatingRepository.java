package com.netthreads.trader.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.netthreads.trader.domain.Rating;

public interface RatingRepository extends CrudRepository<Rating, Serializable> 
{

}

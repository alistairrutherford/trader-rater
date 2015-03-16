package com.netthreads.trader.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.netthreads.trader.domain.SolutionTaskType;
import com.netthreads.trader.service.SolutionTaskTypeService;

/**
 * Used by controllers to convert an ID into a object. 
 *
 */
public class SolutionTaskTypeConvertor implements Converter<String, SolutionTaskType>
{

	@Autowired
	private SolutionTaskTypeService service;
	
	
	@Override
	public SolutionTaskType convert(String source)
	{
		return service.findById(Integer.valueOf(source));
	}
 
}

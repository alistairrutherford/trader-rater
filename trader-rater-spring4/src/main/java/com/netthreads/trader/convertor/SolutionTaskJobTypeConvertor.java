package com.netthreads.trader.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.netthreads.trader.domain.SolutionTaskJobType;
import com.netthreads.trader.service.SolutionTaskJobTypeService;

/**
 * Used by controllers to convert an ID into a object.
 *
 */
public class SolutionTaskJobTypeConvertor implements Converter<String, SolutionTaskJobType>
{

	@Autowired
	private SolutionTaskJobTypeService service;
	
	
	@Override
	public SolutionTaskJobType convert(String source)
	{
		return service.findById(Integer.valueOf(source));
	}
 
}

package com.netthreads.trader.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.netthreads.trader.domain.SolutionType;
import com.netthreads.trader.service.SolutionTypeService;

/**
 * Used by controllers to convert an ID into a object. 
 *
 */
public class SolutionTypeConvertor implements Converter<String, SolutionType>
{

	@Autowired
	private SolutionTypeService service;
	
	
	@Override
	public SolutionType convert(String source)
	{
		return service.findById(Integer.valueOf(source));
	}
 
}

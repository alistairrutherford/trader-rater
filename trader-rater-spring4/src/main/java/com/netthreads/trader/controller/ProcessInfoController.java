package com.netthreads.trader.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * View controller.
 *
 */
@Controller
public class ProcessInfoController
{
	private static final String INDEX_VIEW_MAPPING = "process_info";
	private static final String IMNDEX_VIEW_URL = "process_info";
	
	@RequestMapping(value =  INDEX_VIEW_MAPPING, method = RequestMethod.GET)
	public String index(Map<String, Object> model)
	{
		return IMNDEX_VIEW_URL;
	}
}

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
public class HomeController
{
	private static final String INDEX_VIEW_MAPPING = "/";
	public static final String INDEX_VIEW_URL = "home";
	
	@RequestMapping(value =  INDEX_VIEW_MAPPING, method = RequestMethod.GET)
	public String home(Map<String, Object> model)
	{
		return INDEX_VIEW_URL;
	}
}

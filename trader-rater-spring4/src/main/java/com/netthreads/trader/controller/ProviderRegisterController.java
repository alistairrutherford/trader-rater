package com.netthreads.trader.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netthreads.trader.domain.Provider;

/**
 * View controller.
 *
 */
@Controller
public class ProviderRegisterController
{
	
	// Index page
	private static final String INDEX_VIEW_MAPPING = "provider_register";
	private static final String INDEX_VIEW_URL = "provider_register";
	
	// Success Page
	private static final String REGISTERED_VIEW_MAPPING = "registered_provider";
	private static final String REGISTERED_VIEW_URL = "registered_provider";

	private static final String MODEL_ATTR_PROVIDER = "provider";
	
	// -------------------------------------------------------------------
	// -------------------------------------------------------------------
	@ModelAttribute(MODEL_ATTR_PROVIDER)
	private Provider prepareProviderModel()
	{
		return new Provider();
	}

	/**
	 * Handle index view.
	 * 
	 * @param model
	 * 
	 * @return The view URL.
	 */
	@RequestMapping(value = INDEX_VIEW_MAPPING, method = RequestMethod.GET)
	public String index(Map<String, Object> model)
	{
		
		return INDEX_VIEW_URL;
	}

	/**
	 * Form POST
	 * 
	 * @param provider
	 * @param model
	 * 
	 * @return The view.
	 */
	@RequestMapping(value = INDEX_VIEW_MAPPING, method = RequestMethod.POST)
	public String insertProvider(Provider provider, Model model) 
	{
	    // TODO Add provider
	    
	    return REGISTERED_VIEW_URL;
	}
	
	/**
	 * Handle register success.
	 * 
	 * @param model
	 * 
	 * @return The view URL.
	 */
	@RequestMapping(value = REGISTERED_VIEW_MAPPING)
	public String registeredClient(Map<String, Object> model)
	{
		// Authorise
		
		return REGISTERED_VIEW_URL;
	}
	
}

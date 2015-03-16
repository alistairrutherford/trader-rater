package com.netthreads.trader.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netthreads.trader.domain.SolutionTaskType;
import com.netthreads.trader.domain.SolutionType;
import com.netthreads.trader.service.SolutionTaskTypeService;
import com.netthreads.trader.service.SolutionTypeService;

/**
 * Provider Search Controller.
 *
 * Note: In order to be able to serialise domain objects directly we must
 * suppress the composite references and just leave the data we are interested
 * in passing.
 * 
 */
@Controller
public class ProviderSearchController
{
	private static final String ACCEPT_JSON_FORMAT = "Accept=application/json";
	
	private static final String INDEX_VIEW_MAPPING = "/provider_search";
	private static final String INDEX_VIEW_URL = "provider_search";
	
	private static final String PROVIDER_SELECT_TYPE_MAPPING = "/provider_select_type";
	
	private static final String MODEL_ATTR_SOLUTION_TYPES = "solutionTypes";
	private static final String MODEL_ATTR_SEARCH = "search";
	
	private SolutionTypeService solutionTypeService;
	
	private SolutionTaskTypeService solutionTaskTypeService;
	
	/**
	 * Form bean.
	 *
	 */
	public class Search
	{
		private String providerType;
		private String serviceType;
		private String description;
		private String postCode;
		private Date startingDate;
		
		public String getProviderType()
		{
			return providerType;
		}
		
		public void setProviderType(String providerType)
		{
			this.providerType = providerType;
		}
		
		public String getSolutionType()
		{
			return serviceType;
		}
		
		public void setSolutionType(String serviceType)
		{
			this.serviceType = serviceType;
		}
		
		public String getDescription()
		{
			return description;
		}
		
		public void setDescription(String description)
		{
			this.description = description;
		}

		public String getPostCode()
		{
			return postCode;
		}

		public void setPostCode(String postCode)
		{
			this.postCode = postCode;
		}

		public Date getStartingDate()
		{
			return startingDate;
		}

		public void setStartingDate(Date startingDate)
		{
			this.startingDate = startingDate;
		}
		
	};
	
	// -------------------------------------------------------------------
	// Model
	// -------------------------------------------------------------------
	
	/**
	 * Form model.
	 * 
	 * @return model.
	 */
	@ModelAttribute(MODEL_ATTR_SEARCH)
	private Search providerSearchModel()
	{
		return new Search();
	}
	
	/**
	 * Provider type names.
	 * 
	 * @return Add list to session model.
	 */
	@ModelAttribute(MODEL_ATTR_SOLUTION_TYPES)
	private Iterable<SolutionType> providerTypeModel()
	{
		Iterable<SolutionType> values = solutionTypeService.findAll();
		
		return values;
	}
	
	// -------------------------------------------------------------------
	// Controller
	// -------------------------------------------------------------------
	
	/**
	 * Wire in the services.
	 * 
	 * @param serviceTypeService
	 */
	@Autowired
	public ProviderSearchController(SolutionTypeService serviceTypeService, SolutionTaskTypeService solutionTaskTypeService)
	{
		this.solutionTypeService = serviceTypeService;
		this.solutionTaskTypeService = solutionTaskTypeService;
	}
	
	/**
	 * Index view.
	 * 
	 * @param model
	 * 
	 * @return The view.
	 */
	@RequestMapping(value = INDEX_VIEW_MAPPING, method = RequestMethod.GET)
	public String index(Map<String, Object> model)
	{
		return INDEX_VIEW_URL;
	}
	
	/**
	 * Handle select type.
	 * 
	 * @param select
	 * 
	 * @return Response
	 */
	@RequestMapping(value = PROVIDER_SELECT_TYPE_MAPPING + "/{title}", headers = ACCEPT_JSON_FORMAT)
	@ResponseBody
	public Collection<SolutionTaskType> providerSelectType(@PathVariable String title)
	{
		SolutionType solutionType = solutionTypeService.findByTitle(title);
		
		Collection<SolutionTaskType> titles = solutionTaskTypeService.findBySolutionType(solutionType);
		
		return titles;
	}
	
}

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
public class LoginInfoController
{
	private static final String INDEX_VIEW_MAPPING = "login_info";
	private static final String INDEX_VIEW_URL = "login_info";
	
	private static final String LOGIN_CLIENT_VIEW_MAPPING = "login_client";
	
	private static final String LOGIN_PROVIDER_VIEW_MAPPING = "login_provider";
	
	private static final String MODEL_ATTR_LOGIN_CLIENT = "client_login";
	private static final String MODEL_ATTR_LOGIN_PROVIDER = "provider_login";
	
	@SuppressWarnings("unused")
	private class LoginBean
	{
		private String userName;
		private String password;
		
        public String getUserName()
		{
			return userName;
		}
		
		public void setUserName(String userName)
		{
			this.userName = userName;
		}
		
		public String getPassword()
		{
			return password;
		}
		
		public void setPassword(String password)
		{
			this.password = password;
		}
		
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
		model.put(MODEL_ATTR_LOGIN_CLIENT, new LoginBean());
		model.put(MODEL_ATTR_LOGIN_PROVIDER, new LoginBean());
		
		return INDEX_VIEW_URL;
	}
	
	/**
	 * Handle client login form.
	 * 
	 * @param model
	 * 
	 * @return The view URL.
	 */
	@RequestMapping(value = LOGIN_CLIENT_VIEW_MAPPING, params =
	{
		"login"
	})
	public String loginClient(Map<String, Object> model)
	{
		// Authorise
		
		return HomeController.INDEX_VIEW_URL;
	}
	
	/**
	 * Handle provider login.
	 * 
	 * @param model
	 * 
	 * @return The view URL.
	 */
	@RequestMapping(value = LOGIN_PROVIDER_VIEW_MAPPING, params =
	{
		"login"
	})
	public String loginProvider(Map<String, Object> model)
	{
		// Authorise
		
		return HomeController.INDEX_VIEW_URL;
	}
	
}

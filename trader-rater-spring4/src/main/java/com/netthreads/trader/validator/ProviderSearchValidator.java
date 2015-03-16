package com.netthreads.trader.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.netthreads.trader.controller.ProviderSearchController;

/**
 * Input validator.
 *
 */
@Component
public class ProviderSearchValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz)
	{
		return ProviderSearchController.Search.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors)
	{
		ProviderSearchController.Search search = (ProviderSearchController.Search) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "errors.search.descriptionEmpty", "Please enter a description");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postCode", "errors.search.postCodeEmpty", "Please enter a post code");
		
	}
}

package com.netthreads.trader.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.netthreads.trader.domain.Client;

@Component
public class ClientValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return Client.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		Client client = (Client) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName}", "name.empty");
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName}", "name.empty");
	}

}

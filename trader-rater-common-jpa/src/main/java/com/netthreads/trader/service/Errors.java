package com.netthreads.trader.service;

public interface Errors
{
	public static final String ERROR_NO_DATA = "No Data.";

	public static final String ERROR_CANNOT_CREATE = "Cannot create, ";
	public static final String ERROR_CANNOT_UPDATE = "Cannot update, ";
	public static final String ERROR_CANNOT_DELETE = "Cannot delete, ";

	public static final String ERROR_USER_ALREADY_EXISTS = "User already exists.";
	public static final String ERROR_USER_DOES_NOT_EXIST = "User does not already exists.";
	public static final String ERROR_NO_USER_ASSOCIATED_WITH_CLIENT = "No user associated with client";
	
	public static final String ERROR_TASK_STATE_ALREADY_EXISTS = "Task State already exists.";

	public static final String ERROR_NULL_PARAMETER = "Null parameter.";

}

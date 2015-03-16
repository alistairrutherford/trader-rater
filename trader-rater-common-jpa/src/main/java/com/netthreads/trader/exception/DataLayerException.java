package com.netthreads.trader.exception;

@SuppressWarnings("serial")
public class DataLayerException extends Exception
{
	/**
	 * Data Layer specific exception.
	 * 
	 * @param message
	 */
	public DataLayerException(String message)
	{
		super(message);
	}
}

package com.netthreads.trader.dao;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractEntity<P> implements Serializable
{
	public abstract P getId();
}
package com.netthreads.trader.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.netthreads.trader.dao.AbstractEntity;

/**
 * Static table.
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = BidState.TABLE_NAME)
public class BidState extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "bid_state";
	
	public static final String COLUMN_ID = "bid_state_id"; 
	public static final String COLUMN_STATE = "state"; 
	
	public enum State
	{
		UNPUBLISHED, PUBLISHED
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Override
	public Long getId()
	{
		return id;
	}
	
	public State getState()
	{
		return state;
	}
	
	public void setState(State state)
	{
		this.state = state;
	}
	
}

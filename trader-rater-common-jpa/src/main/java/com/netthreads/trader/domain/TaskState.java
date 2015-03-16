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

@SuppressWarnings("serial")
@Entity
@Table(name = TaskState.TABLE_NAME)
public class TaskState extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "task_state";
	
	public static final String COLUMN_ID = "task_state_id";
	public static final String COLUMN_STATE = "state";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCRIPTION = "description";
	
	public enum State
	{
		UNPUBLISHED, PUBLISHED, ASSIGNED, COMPLETED
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Column(name = COLUMN_TITLE)
	private String title;
	
	@Enumerated(EnumType.STRING)
	@Column(name = COLUMN_STATE)
	private State state;
	
	@Column(name = COLUMN_DESCRIPTION)
	private String description;
	
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
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
}

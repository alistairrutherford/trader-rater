package com.netthreads.trader.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.netthreads.trader.dao.AbstractEntity;

/**
 * Static data table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = TaskType.TABLE_NAME)
public class TaskType extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "task_type";
	
	public static final String COLUMN_ID = "task_type_id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCRIPTION = "description";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Column(name = COLUMN_TITLE)
	private String title;
	
	@Column(name = COLUMN_DESCRIPTION)
	private String description;
	
	@Override
	public Long getId()
	{
		return id;
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

package com.netthreads.trader.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netthreads.trader.dao.AbstractEntity;

/**
 * Static data table.
 * 
 * Plumber, builder etc.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = SolutionType.TABLE_NAME)
public class SolutionType extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "solution_type";
	
	public static final String COLUMN_ID = "solution_type_id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCIPTION = "description";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	@JsonIgnore
	private Long id;
	
	@Column(name = COLUMN_TITLE)
	private String title;
	
	@Column(name = COLUMN_DESCIPTION)
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = SolutionTaskType.COLUMN_OWNER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SolutionTaskType> taskTypes;
	
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
	
	public List<SolutionTaskType> getTaskTypes()
	{
		return taskTypes;
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

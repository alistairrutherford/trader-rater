package com.netthreads.trader.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netthreads.trader.dao.AbstractEntity;

/**
 * Static data table.
 * 
 * Build extension, install kitchen etc.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = SolutionTaskType.TABLE_NAME)
public class SolutionTaskType extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "solution_task_type";
	
	public static final String COLUMN_ID = "solution_task_type_id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCIPTION = "description";
	public static final String COLUMN_OWNER = "owner";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	@JsonIgnore
	private Long id;
	
	@Column(name = COLUMN_TITLE)
	private String title;
	
	@Column(name = COLUMN_DESCIPTION)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = SolutionType.COLUMN_ID)
	@JsonIgnore
	private SolutionType owner;
	
	@OneToMany(mappedBy = SolutionTaskJobType.COLUMN_OWNER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SolutionTaskJobType> taskJobTypes;
	
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
	
	public SolutionType getOwner()
	{
		return owner;
	}
	
	public void setOwner(SolutionType owner)
	{
		this.owner = owner;
	}
	
	public List<SolutionTaskJobType> getTaskJobTypes()
	{
		return taskJobTypes;
	}
	
	public void setTaskJobTypes(List<SolutionTaskJobType> taskJobTypes)
	{
		this.taskJobTypes = taskJobTypes;
	}
	
}

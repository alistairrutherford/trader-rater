package com.netthreads.trader.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netthreads.trader.dao.AbstractEntity;

/**
 * Provider details describes provider 'type' and assigned a static type e.g.
 * plumber etc.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = Solution.TABLE_NAME)
public class Solution extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "solution";
	
	public static final String COLUMN_ID = "solution_id";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_OWNER = "owner";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	@JsonIgnore
	private Long id;
	
	@Column(name = COLUMN_DESCRIPTION)
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = SolutionType.COLUMN_ID, updatable = false, insertable = false)
	@JsonIgnore
	private SolutionType solutionType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Provider.COLUMN_ID, updatable = false, insertable = false)
	@JsonIgnore
	private Provider owner;
	
	@Override
	public Long getId()
	{
		return id;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public SolutionType getSolutionType()
	{
		return solutionType;
	}
	
	public void setSolutionType(SolutionType serviceType)
	{
		this.solutionType = serviceType;
	}
	
	public Provider getOwner()
	{
		return owner;
	}
	
	public void setOwner(Provider owner)
	{
		this.owner = owner;
	}
	
}

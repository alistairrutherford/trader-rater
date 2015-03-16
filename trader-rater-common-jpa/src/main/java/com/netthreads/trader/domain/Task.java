package com.netthreads.trader.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.netthreads.trader.dao.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = Task.TABLE_NAME)
public class Task extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "task";
	
	public static final String COLUMN_ID = "task_id";
	public static final String COLUMN_POST_CODE = "post_code";
	public static final String COLUMN_CREATED = "created";
	public static final String COLUMN_STATE = "state";
	public static final String COLUMN_OWNER = "owner";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Column(name = COLUMN_POST_CODE)
	private String postCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUMN_CREATED)
	private Date created;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = SolutionTaskJobType.COLUMN_ID)
	private SolutionTaskJobType serviceTaskJobType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = SolutionTaskType.COLUMN_ID, updatable = false, insertable = false)
	private SolutionTaskType serviceTaskType;

	// Plumber
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = SolutionType.COLUMN_ID, updatable = false, insertable = false)
	private SolutionType serviceType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = TaskState.COLUMN_ID, updatable = false, insertable = false)
	private TaskState taskState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Client.COLUMN_ID)
	private Client owner;
	
	@Override
	public Long getId()
	{
		return id;
		
	}
	
	public String getPostCode()
	{
		return postCode;
	}
	
	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}
	
	public Date getCreated()
	{
		return created;
	}
	
	public void setCreated(Date created)
	{
		this.created = created;
	}
	
	public TaskState getTaskState()
	{
		return taskState;
	}
	
	public void setTaskState(TaskState taskState)
	{
		this.taskState = taskState;
	}
	
	public SolutionTaskJobType getServiceTaskJobType()
	{
		return serviceTaskJobType;
	}
	
	public void setServiceTaskJobType(SolutionTaskJobType serviceTaskJobType)
	{
		this.serviceTaskJobType = serviceTaskJobType;
	}
	
	public SolutionTaskType getServiceTaskType()
	{
		return serviceTaskType;
	}
	
	public void setServiceTaskType(SolutionTaskType serviceTaskType)
	{
		this.serviceTaskType = serviceTaskType;
	}
	
	public SolutionType getServiceType()
	{
		return serviceType;
	}
	
	public void setServiceType(SolutionType serviceType)
	{
		this.serviceType = serviceType;
	}
	
	public Client getOwner()
	{
		return owner;
	}
	
	public void setOwner(Client owner)
	{
		this.owner = owner;
	}
	
}

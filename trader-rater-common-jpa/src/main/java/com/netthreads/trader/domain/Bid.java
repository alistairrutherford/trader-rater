package com.netthreads.trader.domain;

import java.math.BigDecimal;
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
@Table(name = Bid.TABLE_NAME)
public class Bid extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "bid";

	public static final String COLUMN_ID = "bid_id";
	public static final String COLUMN_VALUE = "value";
	public static final String COLUMN_CREATED = "created";
	public static final String COLUMN_TASK = "task";
	public static final String COLUMN_OWNER = "owner";
	public static final String COLUMN_BID_STATE = "bid_state";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;

	@Column(name = COLUMN_VALUE)
	private BigDecimal value;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUMN_CREATED)
	private Date created;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Provider.COLUMN_ID, updatable=false, insertable=false)
	private Provider owner;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Task.COLUMN_ID, updatable=false, insertable=false)
	private Task task;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = BidState.COLUMN_ID, updatable=false, insertable=false)
	private BidState bidState;

	public Provider getOwner()
	{
		return owner;
	}

	public void setOwner(Provider owner)
	{
		this.owner = owner;
	}

	public Task getTask()
	{
		return task;
	}

	public void setTask(Task task)
	{
		this.task = task;
	}

	@Override
	public Long getId()
	{
		return id;
	}

	public BigDecimal getValue()
	{
		return value;
	}

	public void setValue(BigDecimal value)
	{
		this.value = value;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public BidState getBidState()
	{
		return bidState;
	}

	public void setBidState(BidState bidState)
	{
		this.bidState = bidState;
	}

}

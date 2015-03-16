package com.netthreads.trader.domain;

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

import com.netthreads.trader.dao.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = Rating.TABLE_NAME)
public class Rating extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "rating";

	public static final String COLUMN_ID = "rating_id";
	public static final String COLUMN_OWNER = "owner";
	public static final String COLUMN_TASK = "task";
	public static final String COLUMN_SCORE = "score";
	public static final String COLUMN_SHORT_DESCRIPTION = "short_description";
	public static final String COLUMN_LONG_DESCRIPTION = "long_description";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;

	@Column(name = COLUMN_SCORE)
	private int score;

	@Column(name = COLUMN_SHORT_DESCRIPTION)
	private String shortDescription;

	@Column(name = COLUMN_LONG_DESCRIPTION)
	private String longDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Client.COLUMN_ID)
	private Client owner;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Task.COLUMN_ID)
	private Task task;

	@Override
	public Long getId()
	{
		return id;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public String getShortDescription()
	{
		return shortDescription;
	}

	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	public String getLongDescription()
	{
		return longDescription;
	}

	public void setLongDescription(String longDescription)
	{
		this.longDescription = longDescription;
	}

	public Task getTask()
	{
		return task;
	}

	public void setTask(Task task)
	{
		this.task = task;
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

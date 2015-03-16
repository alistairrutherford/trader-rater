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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.netthreads.trader.dao.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = Client.TABLE_NAME)
public class Client extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "client";

	public static final String COLUMN_ID = "client_id";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = UserDetails.COLUMN_ID)
	private UserDetails userDetails;

	@OneToMany(mappedBy = Rating.COLUMN_OWNER, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Rating> ratings;

	@OneToMany(mappedBy = Task.COLUMN_OWNER, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Task> tasks;

	public List<Rating> getRatings()
	{
		return ratings;
	}

	public void setRatings(List<Rating> ratings)
	{
		this.ratings = ratings;
	}

	public void setTasks(List<Task> tasks)
	{
		this.tasks = tasks;
	}

	@Override
	public Long getId()
	{
		return id;
	}

	public UserDetails getUserDetails()
	{
		return userDetails;
	}

	public void setUserDetails(UserDetails user)
	{
		this.userDetails = user;
	}

	/**
	 * Add task to list.
	 * 
	 * @param task
	 */
	public void addTask(Task task)
	{
		this.tasks.add(task);
		if (task.getOwner() != this)
		{
			task.setOwner(this);
		}
	}

	/**
	 * Return tasks.
	 * 
	 * @return The task list.
	 */
	public List<Task> getTasks()
	{
		return tasks;
	};

}

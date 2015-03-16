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
@Table(name = Provider.TABLE_NAME)
public class Provider extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "provider";
	
	public static final String COLUMN_ID = "provider_id";
	public static final String COLUMN_BIDS = "bids";
	public static final String COLUMN_TITLE = "title";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Column(name = COLUMN_TITLE)
	private String title;
	
	// Note: JoinColumn means there HAS TO BE a Provider associated with the the
	// element.
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = UserDetails.COLUMN_ID)
	private UserDetails userDetails;
	
	@OneToMany(mappedBy = Solution.COLUMN_OWNER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Solution> solution;
	
	@OneToMany(mappedBy = Bid.COLUMN_OWNER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Bid> bids;
	
	@Override
	public Long getId()
	{
		return id;
	}
	
	public String getBusinessTitle()
	{
		return title;
	}
	
	public void setBusinessTitle(String businessTitle)
	{
		this.title = businessTitle;
	}
	
	public UserDetails getUserDetails()
	{
		return userDetails;
	}
	
	public void setUserDetails(UserDetails userDetails)
	{
		this.userDetails = userDetails;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public List<Solution> getSolution()
	{
		return solution;
	}
	
	public void setSolution(List<Solution> service)
	{
		this.solution = service;
	}
	
	public List<Bid> getBids()
	{
		return bids;
	}
	
	public void setBids(List<Bid> bids)
	{
		this.bids = bids;
	}
	
}

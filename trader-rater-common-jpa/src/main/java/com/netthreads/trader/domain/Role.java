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

/**
 * Static data table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "role";
	
	public static final String NAME_CLIENT = "Client";
	public static final String NAME_PROVIDER = "Provider";
	public static final String NAME_ADMIN = "Admin";
	
	public static final String COLUMN_ID = "role_id";
	public static final String COLUMN_TYPE = "role_type";
	public static final String COLUMN_TITLE = "title";
	
	public enum RoleType
	{
		CLIENT, PROVIDER, ADMIN
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = COLUMN_TYPE)
	private RoleType roleType;
	
	@Column(name = COLUMN_TITLE)
	private String title;
	
	@Override
	public Long getId()
	{
		return id;
	}
	
	public RoleType getRoleType()
	{
		return roleType;
	}
	
	public void setRoleType(RoleType roleType)
	{
		this.roleType = roleType;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
}

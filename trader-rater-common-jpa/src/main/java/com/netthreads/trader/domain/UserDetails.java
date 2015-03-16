package com.netthreads.trader.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.netthreads.trader.dao.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = UserDetails.TABLE_NAME)
public class UserDetails extends AbstractEntity<Long>
{
	public static final String TABLE_NAME = "user_details";
	
	public static final String COLUMN_ID = "user_details_id";
	public static final String COLUMN_USER_NAME = "user_name";
	public static final String COLUMN_FIRST_NAME = "first_name";
	public static final String COLUMN_LAST_NAME = "last_name";
	public static final String COLUMN_ADDRESS = "address";
	public static final String COLUMN_POST_CODE = "post_code";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_MOBILE_PHONE = "mobile_phone";
	public static final String COLUMN_ROLE = "role";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_PASSWORD= "password";
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUMN_ID)
	private Long id;
	
	@Column(name = COLUMN_USER_NAME, nullable = false)
	private String userName;
	
	@Column(name = COLUMN_FIRST_NAME)
	private String firstName;
	
	@Column(name = COLUMN_LAST_NAME)
	private String lastName;
	
	@Column(name = COLUMN_ADDRESS)
	private String address;
	
	@Column(name = COLUMN_POST_CODE)
	private String postCode;
	
	@Column(name = COLUMN_PHONE)
	private String phone;
	
	@Column(name = COLUMN_MOBILE_PHONE)
	private String mobilePhone;
	
	@Column(name = COLUMN_EMAIL)
	private String email;

	@Column(name = COLUMN_PASSWORD)
	private String password;

	@Transient
	private String passwordRepeat;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Role.COLUMN_ID)
	private Role role;
	
	@Override
	public Long getId()
	{
		return id;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getPostCode()
	{
		return postCode;
	}
	
	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getMobilePhone()
	{
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}
	
	public Role getRole()
	{
		return role;
	}
	
	public void setRole(Role role)
	{
		this.role = role;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPasswordRepeat()
	{
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat)
	{
		this.passwordRepeat = passwordRepeat;
	}

	
}
package com.firsthibernateproject;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity(name = "USER_DETAILS")
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	//@Transient ou static para n�o armazenar
	private String userName;
	
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street" ,  column= @Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name = "city"   ,  column= @Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name = "state"  ,  column= @Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name = "pincode",  column= @Column(name="HOME_PIN_CODE")),


		
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;

	@Lob
	private String description;
	
	
	
	
	@Column(name = "USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}

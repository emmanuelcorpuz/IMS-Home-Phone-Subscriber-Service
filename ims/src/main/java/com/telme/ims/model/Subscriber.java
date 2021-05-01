package com.telme.ims.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subscriber")
public class Subscriber {
	
	@Id
	private long phonenumber;
	
	private String username;
	
	private String password;
	
	private String domain;
		
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "phonenumber")
    private List<SubscriberFeature> subscriberFeatures;
	
	public Subscriber() {
		
	}
	
	public Subscriber (long phonenumber, String username, String password, String domain, String status, List<SubscriberFeature> subscriberFeatures) {
		super();
		this.phonenumber = phonenumber;
		this.username = username;
		this.password = password;
		this.domain = domain;
		this.status = status;
		this.subscriberFeatures = subscriberFeatures;
	}
	
		
	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public List<SubscriberFeature> getSubscriberFeatures() {
		return subscriberFeatures;
	}

	public void setSubscriberFeatures(List<SubscriberFeature> subscriberFeatures) {
		this.subscriberFeatures = subscriberFeatures;
	}



	

	
	

}

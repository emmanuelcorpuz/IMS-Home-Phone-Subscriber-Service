package com.telme.ims.beans;

import java.util.List;

import com.telme.ims.model.Feature;

public class SubscriberBean {
	
	private long phoneNumber;
	
	private String username;
	
	private String password;
	
	private String domain;
	
	private String status;
	
	private List<Feature> features;
	
	
	public SubscriberBean() {
		
	}
	
	public SubscriberBean(long phoneNumber, String username, String password, String domain, String status, List<Feature> features) {
		super();
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.domain = domain;
		this.status = status;
		this.features = features;
	}
		
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

}

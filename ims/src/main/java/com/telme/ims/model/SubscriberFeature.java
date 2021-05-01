package com.telme.ims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscriber_feature")
public class SubscriberFeature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private long phonenumber;
	private int featureid;
	
	public SubscriberFeature() {
		
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public long getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public int getFeatureid() {
		return featureid;
	}
	
	public void setFeatureid(int featureid) {
		this.featureid = featureid;
	}



	
	
	

	
}

package com.telme.ims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feature")
public class Feature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int featureid;
	
	private String provisioned;
	private String destination;
	
	public Feature() {
		
	}
	
	public int getFeatureid() {
		return featureid;
	}
	
	public void setFeatureid(int featureid) {
		this.featureid = featureid;
	}
	
	public String getProvisioned() {
		return provisioned;
	}

	public void setProvisioned(String provisioned) {
		this.provisioned = provisioned;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}

	

	
}

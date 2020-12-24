package com.oop.coffee.model.dto;

/**
 * Data Transfer Object -> DTO 
 *
 */

public class Coffee {
	private String origin;
	private String location;
	
	public Coffee() {
		
	}
	public Coffee(String origin, String location) {
		this.origin = origin;
		this.location = location;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String print() {
		return "[origin : " + origin + ", location : " + location + "]";
	}
}

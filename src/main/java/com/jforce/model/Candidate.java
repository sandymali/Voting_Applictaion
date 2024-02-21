package com.jforce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Candidate {

	private int count;
	@Id
	private String name;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

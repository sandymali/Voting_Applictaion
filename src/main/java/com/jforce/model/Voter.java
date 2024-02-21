
package com.jforce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Voter {
	@Id
	private String uname;
	private String pass;
	private String email;
	private long mobile;
	private String voteTo;

	public String getVoteTo() {
		return voteTo;
	}

	public void setVoteTo(String voteTo) {
		this.voteTo = voteTo;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}

package com.codingParkFun.rmsbackend.model;

import javax.persistence.Entity;

@Entity
public class UserDetail {

	private String username;
	private Long schoolId;
	private String role;

	public UserDetail(String username, Long schoolId, String role) {
		this.username = username;
		this.schoolId = schoolId;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

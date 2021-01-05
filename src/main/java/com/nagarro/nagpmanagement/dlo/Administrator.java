package com.nagarro.nagpmanagement.dlo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Administrator {

	@Id
	@Size(max=20)
	private String admin_id ;
	
	private String username;
	
	private String password;
	


	public String getId() {
		return admin_id;
	}

	public void setId(String id) {
		this.admin_id = id;
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
	
}

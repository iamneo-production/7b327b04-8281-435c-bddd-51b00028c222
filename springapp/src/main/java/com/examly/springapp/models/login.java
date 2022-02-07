package com.examly.springapp.models;
//import java.lang.annotation.Inherited;

import javax.persistence.*;
@Entity
public class login {
	@Id
    private String email;
	private String password;
	
	
	public login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public login() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

package com.group.db.springbootmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class User {
@Id	
@GeneratedValue
@Column(name="id")
private int ID;


@Column(name="name")
@NotNull
@Size(min = 4,max =255)
private String name;


//@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d).*$")
@Column(name="password")
@NotNull
@Size(min = 8,max =255)
@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
message="Password must have at least one uppercase, one lowercase letter and one number")
private String Password;



public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getName() {
	return this.name;
}
public void setName(String name) {
	this.name = name;
}

public User(int iD, @NotNull @Size(min = 4, max = 255) String name,
		@NotNull @Size(min = 8, max = 255) @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must have at least one uppercase, one lowercase letter and one number") String password) {
	super();
	ID = iD;
	this.name = name;
	Password = password;
}



}

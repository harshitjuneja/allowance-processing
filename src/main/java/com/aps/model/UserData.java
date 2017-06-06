package com.aps.model;

public class UserData {
	private String name;
	private int days;

	public UserData() {
		name = "kunal";
		days = 5;
	}

	@Override
	public String toString() {
		return "UserData [name=" + name + ", days=" + days + "]";
	}

}

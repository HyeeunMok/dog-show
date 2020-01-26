package com.fastsloth.beans;

import java.io.Serializable;

public class Dog implements Serializable {
	private static final long serialVersionUID = 1L;

	private int number;
	private String name;
	private String ownerName;
	private String breed;
	private String group;
	private String gender;
	private String dogClass;
	private String day1;
	private String day2;
	private String day3;
	private String email;
	private String password;
	private String membership;
	
	public Dog() {
		
	}

	public Dog(int number, String name, String ownerName, String breed, String group, String gender, String dogClass,
			String day1, String day2, String day3, String email, String password, String membership) {
		this.number = number;
		this.name = name;
		this.ownerName = ownerName;
		this.breed = breed;
		this.group = group;
		this.gender = gender;
		this.dogClass = dogClass;
		this.day1 = day1;
		this.day2 = day2;
		this.day3 = day3;
		this.email = email;
		this.password = password;
		this.membership = membership;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDogClass() {
		return dogClass;
	}

	public void setDogClass(String dogClass) {
		this.dogClass = dogClass;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getDay2() {
		return day2;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public String getDay3() {
		return day3;
	}

	public void setDay3(String day3) {
		this.day3 = day3;
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

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Dog [number=" + number + ", name=" + name + ", ownerName=" + ownerName + ", breed=" + breed + ", group="
				+ group + ", gender=" + gender + ", dogClass=" + dogClass + ", day1=" + day1 + ", day2=" + day2 + ", day3="
				+ day3 + ", email=" + email + ", password=" + password + ", membership=" + membership + "]";
	}

		
}

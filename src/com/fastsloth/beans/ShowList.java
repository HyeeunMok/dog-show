package com.fastsloth.beans;

import java.io.Serializable;

public class ShowList implements Serializable {
	private static final long serialVersionUID = 1L;
	String groupName;
	String noOfDogs;
	String breed;
	String maleClass;
	String femaleClass;
	String maleSpecialty;
	String femaleSpecialty;
	
	public ShowList() {
		
	}

	public ShowList(String groupName, String noOfDogs, String breed, String maleClass, String femaleClass,
			String maleSpecialty, String femaleSpecialty) {
		super();
		this.groupName = groupName;
		this.noOfDogs = noOfDogs;
		this.breed = breed;
		this.maleClass = maleClass;
		this.femaleClass = femaleClass;
		this.maleSpecialty = maleSpecialty;
		this.femaleSpecialty = femaleSpecialty;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getNoOfDogs() {
		return noOfDogs;
	}

	public void setNoOfDogs(String noOfDogs) {
		this.noOfDogs = noOfDogs;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getMaleClass() {
		return maleClass;
	}

	public void setMaleClass(String maleClass) {
		this.maleClass = maleClass;
	}

	public String getFemaleClass() {
		return femaleClass;
	}

	public void setFemaleClass(String femaleClass) {
		this.femaleClass = femaleClass;
	}

	public String getMaleSpecialty() {
		return maleSpecialty;
	}

	public void setMaleSpecialty(String maleSpecialty) {
		this.maleSpecialty = maleSpecialty;
	}

	public String getFemaleSpecialty() {
		return femaleSpecialty;
	}

	public void setFemaleSpecialty(String femaleSpecialty) {
		this.femaleSpecialty = femaleSpecialty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ShowList [groupName=" + groupName + ", noOfDogs=" + noOfDogs + ", breed=" + breed + ", maleClass="
				+ maleClass + ", femaleClass=" + femaleClass + ", maleSpecialty=" + maleSpecialty + ", femaleSpecialty="
				+ femaleSpecialty + "]";
	}
}

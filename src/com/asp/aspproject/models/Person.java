package com.asp.aspproject.models;

public class Person {
	
	protected String mFirstName = null;
	protected String mSecondName = null;
	protected String mNickName = null;
	
	public Person(String mFirstName, String mSecondName, String mNickName) {
		super();
		this.mFirstName = mFirstName;
		this.mSecondName = mSecondName;
		this.mNickName = mNickName;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getmFirstName() {
		return mFirstName;
	}
	
	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}
	public String getmSecondName() {
		return mSecondName;
	}
	public void setmSecondName(String mSecondName) {
		this.mSecondName = mSecondName;
	}
	public String getmNickName() {
		return mNickName;
	}
	public void setmNickName(String mNickName) {
		this.mNickName = mNickName;
	}

}

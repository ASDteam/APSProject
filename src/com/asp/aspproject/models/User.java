package com.asp.aspproject.models;

public class User extends Person{
	

	protected String mEmail = null;
	protected String mPassword = null;
	protected String mCreationDate = null;
	protected String mID = null;
	
	public User() {
		super();
	}
	public User(String mFirstName, String mSecondName, String mNickName) {
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmCreationDate() {
		return mCreationDate;
	}
	public void setmCreationDate(String mCreationDate) {
		this.mCreationDate = mCreationDate;
	}
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	
	
	
	

}

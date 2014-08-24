package com.asp.aspproject.models;

import org.json.JSONException;

import com.asp.aspproject.utils.Constants;

public class User extends Person{



	public User() {
		super();
	}


	public String getmEmail() {
		if (this.has("email"))
		{
			try {
				return (String) this.get("email");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}
	public void setmEmail(String mEmail) {
		try {
			this.put("email", mEmail);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public String getmPassword() {
		if (this.has("password"))
		{
			try {
				return (String) this.get("password");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}
	public void setmPassword(String mPassword) {
		try {
			this.put("password", mPassword);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public String getmCreationDate() {
		if (this.has("creationDate"))
		{
			try {
				return (String) this.get("creationDate");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}
	public void setmCreationDate(String mCreationDate) {
		try {
			this.put("creationDate", mCreationDate);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public String getmID() {
		if (this.has("id"))
		{
			try {
				return (String) this.get("id");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}
	public void setmID(String mID) {
		try {
			this.put("id", mID);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}





}

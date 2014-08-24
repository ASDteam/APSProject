package com.asp.aspproject.models;

import org.json.JSONException;
import org.json.JSONObject;

import com.asp.aspproject.utils.Constants;

public class Person extends JSONObject{


	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getmFirstName() {
		if (this.has("firstName"))
		{
			try {
				return (String) this.get("firstName");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}

	public void setmFirstName(String mFirstName) {
		try {
			this.put("firstName", mFirstName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public String getmSecondName() {
		if (this.has("secondName"))
		{
			try {
				return (String) this.get("secondName");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}
	public void setmSecondName(String mSecondName) {
		try {
			this.put("secondName", mSecondName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public String getmNickName() {
		if (this.has("nickName"))
		{
			try {
				return (String) this.get("nickName");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}
	public void setmNickName(String mNickName) {
		try {
			this.put("nickName", mNickName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}

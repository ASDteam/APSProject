package com.asp.aspproject.models;

import org.json.JSONException;

import com.asp.aspproject.utils.Constants;

public class Player extends Person {


	public Player() {
		super();
	}

	public String getmNumber() {
		if (this.has("number"))
		{
			try {
				return (String) this.get("number");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}

	public void setmNumber(String mNumber) {
		try {
			this.put("number", mNumber);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getmTeamName() {
		if (this.has("teamName"))
		{
			try {
				return (String) this.get("teamName");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}

	public void setmTeamName(String mTeamName) {
		try {
			this.put("teamName", mTeamName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getmTeamId() {
		if (this.has("teamName"))
		{
			try {
				return (String) this.get("teamId");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Constants.EMPTY_SRING;
	}

	public void setmTeamId(String mTeamId) {
		try {
			this.put("teamId", mTeamId);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

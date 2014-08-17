package com.asp.aspproject.models;

public class Player extends Person {
	
	protected String mNumber = null;
	protected String mTeamName = null;
	protected String mTeamId = null;
	
	public Player() {
		super();
	}
	
	public Player(String mFirstName, String mSecondName, String mNickName) {
	}

	public String getmNumber() {
		return mNumber;
	}

	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}

	public String getmTeamName() {
		return mTeamName;
	}

	public void setmTeamName(String mTeamName) {
		this.mTeamName = mTeamName;
	}

	public String getmTeamId() {
		return mTeamId;
	}

	public void setmTeamId(String mTeamId) {
		this.mTeamId = mTeamId;
	}
	
	

}

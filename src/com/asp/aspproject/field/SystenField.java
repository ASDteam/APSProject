package com.asp.aspproject.field;

public class SystenField {
	
	//public enum SYSTEMS {S442, S433, S451, S541, S532,S523, S352, S343, END}
	
	//private static String [] SYSTEMS_LABLE = {"442", };
	
	private String mSystem = null;

	public SystenField(String mSystem) {
		super();
		this.mSystem = mSystem;
	}
	
	public SystenField() {
		super();
		mSystem = "";
	}

	public String getmSystem() {
		return mSystem;
	}

	public void setmSystem(String mSystem) {
		this.mSystem = mSystem;
	}
	
	
	
	 public boolean is442()
	 {
		return mSystem.equals("442") ;
	 }
	 
	 public boolean is433()
	 {
		return mSystem.equals("433") ;
	 }
	 
	 public boolean is451()
	 {
		return mSystem.equals("451") ;
	 }
	 
	 public boolean is541()
	 {
		return mSystem.equals("541") ;
	 }
	 
	 public boolean is532()
	 {
		return mSystem.equals("532") ;
	 }
	 
	 public boolean is523()
	 {
		return mSystem.equals("523") ;
	 }
	 
	 public boolean is352()
	 {
		return mSystem.equals("352") ;
	 }
	 
	 public boolean is343()
	 {
		return mSystem.equals("343") ;
	 }
	 
	 

}

package com.asp.aspproject.models;

import java.util.HashMap;

import com.asp.aspproject.R;
import com.asp.aspproject.field.SystenField;

public class PlayerSelection {

	private SystenField mSysten =  null;

	private HashMap<Integer, String> mPositions = null;


	public PlayerSelection(SystenField mSysten) {
		super();
		this.mSysten = mSysten;

		mPositions = new HashMap<Integer, String>();
		
		init();
	}

	public void  init(){

		if (mSysten.is442()){
			init442();
		}
		else if (mSysten.is433()){
			init433();
		}
		else if (mSysten.is451()){
			init451();
		}
		else if (mSysten.is541()){
			init541();
		}
		else if (mSysten.is532()){
			init532();
		}
		else if (mSysten.is523()){
			init523();
		}
		else if (mSysten.is352()){
			init352();
		}
		else if (mSysten.is343()){
			init343();
		}

	}

	public void init442(){

		//strikers
		mPositions.put(R.id.player00, "AC") ;
		mPositions.put(R.id.player01, "AC") ;

		//midlefielders
		mPositions.put(R.id.player10, "MG") ;
		mPositions.put(R.id.player11, "MC") ;
		mPositions.put(R.id.player12, "MC") ;
		mPositions.put(R.id.player13, "MD") ;

		//midlefielders
		mPositions.put(R.id.player20, "DG") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;
		mPositions.put(R.id.player23, "DD") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}
	
	public void init433(){
		//strikers
		mPositions.put(R.id.player00, "AG") ;
		mPositions.put(R.id.player01, "AC") ;
		mPositions.put(R.id.player02, "AD") ;

		//midlefielders
		mPositions.put(R.id.player10, "MG") ;
		mPositions.put(R.id.player11, "MC") ;
		mPositions.put(R.id.player12, "MD") ;

		//midlefielders
		mPositions.put(R.id.player20, "DG") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;
		mPositions.put(R.id.player23, "DD") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}

	public void init451(){
		//strikers
		mPositions.put(R.id.player00, "AC") ;

		//midlefielders
		mPositions.put(R.id.player10, "MG") ;
		mPositions.put(R.id.player11, "MC") ;
		mPositions.put(R.id.player12, "MC") ;
		mPositions.put(R.id.player13, "MC") ;
		mPositions.put(R.id.player14, "MD") ;

		//midlefielders
		mPositions.put(R.id.player20, "DG") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;
		mPositions.put(R.id.player23, "DD") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}
	
	public void init541(){
		//strikers
		mPositions.put(R.id.player00, "AC") ;

		//midlefielders
		mPositions.put(R.id.player10, "MG") ;
		mPositions.put(R.id.player11, "MC") ;
		mPositions.put(R.id.player12, "MC") ;
		mPositions.put(R.id.player13, "MD") ;

		//midlefielders
		mPositions.put(R.id.player20, "DG") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;
		mPositions.put(R.id.player23, "DC") ;
		mPositions.put(R.id.player24, "DD") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}
	
	public void init532(){
		//strikers
		mPositions.put(R.id.player00, "AC") ;
		mPositions.put(R.id.player01, "AC") ;

		//midlefielders
		mPositions.put(R.id.player10, "MG") ;
		mPositions.put(R.id.player11, "MC") ;
		mPositions.put(R.id.player12, "MD") ;

		//midlefielders
		mPositions.put(R.id.player20, "DG") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;
		mPositions.put(R.id.player23, "DC") ;
		mPositions.put(R.id.player24, "DD") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}
	
	public void init523(){
		//strikers
		mPositions.put(R.id.player00, "AG") ;
		mPositions.put(R.id.player01, "AC") ;
		mPositions.put(R.id.player02, "AD") ;

		//midlefielders
		mPositions.put(R.id.player10, "MC") ;
		mPositions.put(R.id.player11, "MC") ;

		//midlefielders
		mPositions.put(R.id.player20, "DG") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;
		mPositions.put(R.id.player23, "DC") ;
		mPositions.put(R.id.player24, "DD") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}
	
	
	
	
	
	public void init343(){
		//strikers
		mPositions.put(R.id.player00, "AG") ;
		mPositions.put(R.id.player01, "AC") ;
		mPositions.put(R.id.player02, "AD") ;
		
		//midlefielders
		mPositions.put(R.id.player10, "MG") ;
		mPositions.put(R.id.player11, "MC") ;
		mPositions.put(R.id.player12, "MC") ;
		mPositions.put(R.id.player13, "MD") ;

		//midlefielders
		mPositions.put(R.id.player20, "DC") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}
	
	
	public void init352(){
		//strikers
		mPositions.put(R.id.player00, "AC") ;
		mPositions.put(R.id.player01, "AC") ;
		
		//midlefielders
		mPositions.put(R.id.player10, "MG") ;
		mPositions.put(R.id.player11, "MC") ;
		mPositions.put(R.id.player12, "MC") ;
		mPositions.put(R.id.player13, "MC") ;
		mPositions.put(R.id.player14, "MD") ;

		//midlefielders
		mPositions.put(R.id.player20, "DC") ;
		mPositions.put(R.id.player21, "DC") ;
		mPositions.put(R.id.player22, "DC") ;

		//goalkeeper		
		mPositions.put(R.id.player30, "G") ;

	}

	public SystenField getmSysten() {
		return mSysten;
	}

	public void setmSysten(SystenField mSysten) {
		this.mSysten = mSysten;
	}

	public HashMap<Integer, String> getmPositions() {
		return mPositions;
	}

	public void setmPositions(HashMap<Integer, String> mPositions) {
		this.mPositions = mPositions;
	}
	

}

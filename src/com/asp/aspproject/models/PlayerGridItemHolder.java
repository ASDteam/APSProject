package com.asp.aspproject.models;

import android.widget.TextView;

public class PlayerGridItemHolder implements IHolder{
	
	public TextView mPlayerNameTv;
	

	@Override
	public void wrapData(Object iObject) {
		mPlayerNameTv.setText(((Player)iObject).getmFirstName() + "/" + ((Player)iObject).getmSecondName());
		
	}


	public TextView getmPlayerNameTv() {
		return mPlayerNameTv;
	}


	public void setmPlayerNameTv(TextView mPlayerNameTv) {
		this.mPlayerNameTv = mPlayerNameTv;
	}

}

package com.asp.aspproject.models;

import android.widget.TextView;

public class PlayerHeaderHolder implements IHolder{
	
	public TextView mHeaderTv;

	@Override
	public void wrapData(Object iObject) {
		mHeaderTv.setText(((String)iObject));
		
	}

	public TextView getmHeaderTv() {
		return mHeaderTv;
	}

	public void setmHeaderTv(TextView mHeaderTv) {
		this.mHeaderTv = mHeaderTv;
	}

}

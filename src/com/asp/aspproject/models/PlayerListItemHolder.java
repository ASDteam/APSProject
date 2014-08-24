package com.asp.aspproject.models;

import org.json.JSONException;
import org.json.JSONObject;

import android.widget.TextView;

public class PlayerListItemHolder implements IHolder{

	public TextView mPlayerNameTv;


	@Override
	public void wrapData(Object iObject) {
		if (((JSONObject)iObject).has("firstName") && ((JSONObject)iObject).has("secondName") )
		{
			try {
				mPlayerNameTv.setText(((JSONObject)iObject).getString("firstName") + "/" + ((JSONObject)iObject).getString("secondName"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public TextView getmPlayerNameTv() {
		return mPlayerNameTv;
	}


	public void setmPlayerNameTv(TextView mPlayerNameTv) {
		this.mPlayerNameTv = mPlayerNameTv;
	}

}

package com.asp.aspproject.models;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;

import com.asp.aspproject.R;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class PlayerListItemHolder implements IHolder{



	private Context mContext = null;


	public TextView mPlayerNameTv;

	public TextView mPlayerMalusTv;
	
	public PlayerListItemHolder(Context context ) {
		super();
		mContext = context;
	}


	public TextView getmPlayerMalusTv() {
		return mPlayerMalusTv;
	}


	public void setmPlayerMalusTv(TextView mPlayerMalusTv) {
		this.mPlayerMalusTv = mPlayerMalusTv;
		this.mPlayerMalusTv.setVisibility(View.GONE);
	}


	@Override
	public void wrapData(Object object) {

		JSONObject player = (JSONObject) object;
		if (player.has("name") )
		{
			try {
				mPlayerNameTv.setText(Html.fromHtml(player.getString("name")));

				JSONObject aProfiles = (JSONObject)player.get("profile");

				Iterator<?> keys = aProfiles.keys();

				while( keys.hasNext() ){
					String key = (String)keys.next();

					if( aProfiles.get(key) instanceof JSONObject ){
						JSONObject aProfile = (JSONObject)aProfiles.get(key);
						if (aProfile.has("malus"))
						{
							Integer malus = aProfile.getInt("malus");

							if (malus != 0)
							{   
								mPlayerMalusTv.setVisibility(View.VISIBLE);
								mPlayerMalusTv.setText(mContext.getString(R.string.malus) + " " + malus);	
							}
							else
							{
								mPlayerMalusTv.setVisibility(View.GONE);

							}
						}
					}

				}


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

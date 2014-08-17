package com.asp.aspproject.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.asp.aspproject.R;
import com.asp.aspproject.models.Player;
import com.asp.aspproject.models.PlayerGridItemHolder;

public class PlayersOnPitchAdapter extends BaseAdapter{

	private Context mContext;
	private ArrayList<Player> mPlayers;

	public PlayersOnPitchAdapter(Context context, ArrayList<Player> aPlayers ) {
		mContext = context;
		this.mPlayers = aPlayers;

	}

	@Override
	public int getCount() {
		return mPlayers.size();
	}

	@Override
	public Object getItem(int position) {
		return mPlayers.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final Player aPlayer = (Player) getItem(position);

		PlayerGridItemHolder aPlayerGridItemHolder = null;

		if (convertView == null) {
			
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			convertView = inflater.inflate(R.layout.player_grid_item, null);
			aPlayerGridItemHolder = new PlayerGridItemHolder();
			//aPlayerGridItemHolder.setmPlayerNameTv((TextView)convertView.findViewById(R.id.id_player_name));
			convertView.setTag(aPlayerGridItemHolder);

		} 
		else 
		{
			aPlayerGridItemHolder = (PlayerGridItemHolder) convertView.getTag();
		}
		
		//aPlayerGridItemHolder.wrapData(aPlayer);
		
		return convertView;	
		
	}

}

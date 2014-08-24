package com.asp.aspproject.adapters;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.asp.aspproject.R;
import com.asp.aspproject.models.Player;
import com.asp.aspproject.models.PlayerHeaderHolder;
import com.asp.aspproject.models.PlayerListItemHolder;

public class PlayerSelectionAdapter extends BaseExpandableListAdapter {

	private Context mContext;
	private List<String> mListDataHeader; // header titles
	// child data in format of header title, child title
	private HashMap<String, List<JSONObject>> mMapDataChild;

	public PlayerSelectionAdapter(Context iContext, List<String> iListDataHeader,
			HashMap<String, List<JSONObject>> iMapChildData) {
		this.mContext = iContext;
		this.mListDataHeader = iListDataHeader;
		this.mMapDataChild = iMapChildData;
	}

	@Override
	public Object getChild(int iGroupPosition, int iChildPosititon) {
		return this.mMapDataChild.get(this.mListDataHeader.get(iGroupPosition))
				.get(iChildPosititon);
	}

	@Override
	public long getChildId(int iGroupPosition, int iChildPosition) {
		return iChildPosition;
	}


	@Override
	public View getChildView(int iGroupPosition, final int iChildPosition,
			boolean isLastChild, View iConvertView, ViewGroup parent) {

		final JSONObject aJsonObject = (JSONObject) getChild(iGroupPosition, iChildPosition);

		PlayerListItemHolder aPlayerItemHolder = null;

		if (iConvertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			iConvertView = infalInflater.inflate(R.layout.player_item, null);

			aPlayerItemHolder = new PlayerListItemHolder();
			aPlayerItemHolder.setmPlayerNameTv((TextView)iConvertView.findViewById(R.id.player_name_in_item));
			iConvertView.setTag(aPlayerItemHolder);

		}
		else
		{
			aPlayerItemHolder = (PlayerListItemHolder) iConvertView.getTag();
		}

		aPlayerItemHolder.wrapData(aJsonObject);

		return iConvertView;
	}

	@Override
	public int getChildrenCount(int iGroupPosition) {
		return this.mMapDataChild.get(this.mListDataHeader.get(iGroupPosition)).size();
	}

	@Override
	public Object getGroup(int iGroupPosition) {
		return this.mListDataHeader.get(iGroupPosition);
	}

	@Override
	public int getGroupCount() {
		return this.mListDataHeader.size();
	}

	@Override
	public long getGroupId(int iGroupPosition) {
		return iGroupPosition;
	}

	@Override
	public View getGroupView(int iGroupPosition, boolean isExpanded, View iConvertView, ViewGroup iParent) {

		String aHeaderTitle = (String) getGroup(iGroupPosition);

		PlayerHeaderHolder aPlayerHeaderHolder = null;

		if (iConvertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			iConvertView = infalInflater.inflate(R.layout.player_header_item, null);

			aPlayerHeaderHolder = new PlayerHeaderHolder();
			aPlayerHeaderHolder.setmHeaderTv((TextView)iConvertView.findViewById(R.id.player_header_text));
			iConvertView.setTag(aPlayerHeaderHolder);

		}
		else
		{
			aPlayerHeaderHolder = (PlayerHeaderHolder) iConvertView.getTag();
		}

		aPlayerHeaderHolder.wrapData(aHeaderTitle);

		return iConvertView;
	}



	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}



}

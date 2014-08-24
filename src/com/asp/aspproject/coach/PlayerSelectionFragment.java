package com.asp.aspproject.coach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import com.asp.aspproject.R;
import com.asp.aspproject.SplashActivity;
import com.asp.aspproject.adapters.PlayerSelectionAdapter;
import com.asp.aspproject.models.Player;

public class PlayerSelectionFragment extends Fragment implements OnChildClickListener{

	public static final String ARG_VIEW_ID = "SELECTED_VIEW_ID";
	private PlayerSelectionAdapter mListAdapter;
	private ExpandableListView mExpListView;
	private List<String> mlistDataHeader;
	private HashMap<String, List<JSONObject>> mMapDataChild;

	private IPlayerSelection mPlayerSelection;
	private int mSelectedViewId = 0;





	public PlayerSelectionFragment() {
		super();
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle=  getArguments(); 

		if (bundle != null && bundle.containsKey(PlayerSelectionFragment.ARG_VIEW_ID))
		{
			mSelectedViewId = bundle.getInt(PlayerSelectionFragment.ARG_VIEW_ID);
		}
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.player_selection_list, container, false);  

		mExpListView = (ExpandableListView) view.findViewById(R.id.players_expandableListview);

		// preparing list data
		prepareListData();

		mListAdapter = new PlayerSelectionAdapter(this.getActivity(), mlistDataHeader, mMapDataChild);

		// setting list adapter
		mExpListView.setAdapter(mListAdapter);


		for (int groupPosition = 0; groupPosition < mListAdapter.getGroupCount(); groupPosition++)
			mExpListView.expandGroup(groupPosition);

		mExpListView.setOnChildClickListener(this);


		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception
		try {
			mPlayerSelection = (IPlayerSelection) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement IPlayerSelection");
		}

	}

	private void prepareListData() {
		mlistDataHeader = new ArrayList<String>();
		mMapDataChild = new HashMap<String, List<JSONObject>>();

		// Adding child data
		mlistDataHeader.add("GoalKeepers");
		mlistDataHeader.add("Defenders");
		mlistDataHeader.add("MidleFielders");
		mlistDataHeader.add("Strikers");


		try {
			// Adding child data
			List<JSONObject> GoalKeepers = new ArrayList<JSONObject>();
			JSONObject aJsonObject = new JSONObject();
			aJsonObject.put("firstName", "Manuel");

			aJsonObject.put("secondName", "Nauer");
			GoalKeepers.add(aJsonObject);

			aJsonObject = new JSONObject();
			aJsonObject.put("firstName", "Ben");
			aJsonObject.put("secondName", "Ben");
			GoalKeepers.add(aJsonObject);


			List<JSONObject> Defenders = new ArrayList<JSONObject>();
			List<JSONObject> MidleFielders = new ArrayList<JSONObject>();
			List<JSONObject> Strikers = new ArrayList<JSONObject>();
			for (int i = 1; i < 10; i++)
			{
				aJsonObject = new JSONObject();
				aJsonObject.put("firstName", "Defender");
				aJsonObject.put("secondName", ""+i);
				Defenders.add(aJsonObject);

				aJsonObject = new JSONObject();
				aJsonObject.put("firstName", "MidleFielder");
				aJsonObject.put("secondName", ""+i);
				MidleFielders.add(aJsonObject);

				aJsonObject = new JSONObject();
				aJsonObject.put("firstName", "Striker");
				aJsonObject.put("secondName", ""+i);
				Strikers.add(aJsonObject);

			}


			mMapDataChild.put(mlistDataHeader.get(0), GoalKeepers); // Header, Child data
			mMapDataChild.put(mlistDataHeader.get(1), Defenders); 
			mMapDataChild.put(mlistDataHeader.get(2), MidleFielders); 
			mMapDataChild.put(mlistDataHeader.get(3), Strikers); 

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public boolean onChildClick(ExpandableListView parent, View item, int groupPosition, int childPosition, long rowId) {

		if (mSelectedViewId != 0)
		{
			JSONObject aJsonObject = (JSONObject) this.mMapDataChild.get(mlistDataHeader.get(groupPosition)).get(childPosition);
			if (aJsonObject.has("firstName") && aJsonObject.has("secondName") )
				try {

					Toast.makeText(this.getActivity(), "player : " + aJsonObject.getString("firstName")  + "/" + aJsonObject.has("secondName"), Toast.LENGTH_SHORT).show();

					mPlayerSelection.onPlayerSelected(mSelectedViewId, aJsonObject.getString("firstName") + "/" + aJsonObject.getString("secondName"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return true;
	}


}

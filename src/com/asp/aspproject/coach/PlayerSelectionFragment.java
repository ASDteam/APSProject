package com.asp.aspproject.coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

import com.asp.aspproject.R;
import com.asp.aspproject.adapters.PlayerSelectionAdapter;
import com.asp.aspproject.request.RequestHandler;
import com.asp.aspproject.utils.Constants.CACHE_KEY;

public class PlayerSelectionFragment extends Fragment implements OnChildClickListener{

	public static final String ARG_VIEW_ID = "SELECTED_VIEW_ID";
	public static final String ARG_VIEW_POSITION = "SELECTED_VIEW_POSITION";
	private PlayerSelectionAdapter mListAdapter;
	private ExpandableListView mExpListView;
	private List<String> mlistDataHeader;
	private HashMap<String, ArrayList<JSONObject>> mMapDataChild;

	private IPlayerSelection mPlayerSelection;
	private int mSelectedViewId = 0;

	private String mPlaceOnPitch = null;





	public PlayerSelectionFragment() {
		super();
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle=  getArguments(); 

		if (bundle != null)
		{
			if ( bundle.containsKey(PlayerSelectionFragment.ARG_VIEW_ID))
			{
				mSelectedViewId = bundle.getInt(PlayerSelectionFragment.ARG_VIEW_ID);
			}

			if ( bundle.containsKey(PlayerSelectionFragment.ARG_VIEW_POSITION))
			{
				mPlaceOnPitch = bundle.getString(PlayerSelectionFragment.ARG_VIEW_POSITION);
			}
		}

		String aUrl =  "http://google.com";

		RequestHandler mRequestHandler = new RequestHandler(aUrl, null, this, "onResponse", this.getActivity(), CACHE_KEY.FILE_PLAYER_LIST_KEY);
		mRequestHandler.getData();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.player_selection_list, container, false);  

		mExpListView = (ExpandableListView) view.findViewById(R.id.players_expandableListview);

		// preparing list data
		//prepareListData();

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

	public void onResponse(Object response)
	{

		if (response != null)
		{
			Log.e("PlayerSelectionFragment::onResponse", (String)response);

			mlistDataHeader = new ArrayList<String>();
			mMapDataChild = new HashMap<String, ArrayList<JSONObject>>();

			mlistDataHeader.add("Players");

			try {
				JSONArray ajJsonArray = new JSONArray((String)response);
				sortPlayersList(ajJsonArray);

				mListAdapter = new PlayerSelectionAdapter(this.getActivity(), mlistDataHeader, mMapDataChild);

				// setting list adapter
				mExpListView.setAdapter(mListAdapter);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}




			for (int groupPosition = 0; groupPosition < mListAdapter.getGroupCount(); groupPosition++)
				mExpListView.expandGroup(groupPosition);

			mExpListView.setOnChildClickListener(this);
		}

	}

	private void sortPlayersList(JSONArray jsonArray){

		mlistDataHeader = new ArrayList<String>();
		mMapDataChild = new HashMap<String, ArrayList<JSONObject>>();

		mlistDataHeader.add("players");
		ArrayList<JSONObject>  aJsonObjects = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArray.length(); i++)
		{
			JSONObject aPlayer;
			try {
				aPlayer = (JSONObject) (jsonArray.get(i));

				JSONObject aProfiles = (JSONObject)aPlayer.get("profile");

				Iterator<?> keys = aProfiles.keys();

				Vector<String> keysToRemove = new Vector<String>();

				while( keys.hasNext() ){
					String key = (String)keys.next();
					if (key.equals(mPlaceOnPitch))
					{
						aJsonObjects.add(aPlayer);

					}
					else
					{
						keysToRemove.add(key);
					}
				}

				//remove not selected profile
				for (String key :keysToRemove)
				{
					aProfiles.remove(key);
				}


			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Collections.sort(aJsonObjects, new Comparator<JSONObject>() {

			@Override
			public int compare(JSONObject lhs, JSONObject rhs) {

				int result = -1;

				try {

					JSONObject leftProfile = (JSONObject) lhs.get("profile");
					JSONObject rightProfile = (JSONObject) rhs.get("profile");

					Iterator<?> leftKeys = leftProfile.keys();
					Iterator<?> rightKeys = rightProfile.keys();

					int letMalus = 0;
					int rightMalus = 0;

					while( leftKeys.hasNext() ){
						String key = (String)leftKeys.next();

						if( leftProfile.get(key) instanceof JSONObject ){
							JSONObject aProfile = (JSONObject)leftProfile.get(key);
							if (aProfile.has("malus"))
							{
								letMalus = aProfile.getInt("malus");

							}
						}

					}

					while( rightKeys.hasNext() ){
						String key = (String)rightKeys.next();


						if( rightProfile.get(key) instanceof JSONObject ){
							JSONObject aProfile = (JSONObject)rightProfile.get(key);
							if (aProfile.has("malus"))
							{
								rightMalus = aProfile.getInt("malus");

							}
						}

					}
					if ( letMalus > rightMalus)
					{
						result = 1;
					}
					else if (letMalus == rightMalus)
					{
						result = 0;
					}


				} catch (JSONException e) {
					e.printStackTrace();
				}
				return result;

			}
		});

		mMapDataChild.put(mlistDataHeader.get(0), aJsonObjects);


	}

	/*private void prepareListData() {
		mlistDataHeader = new ArrayList<String>();
		mMapDataChild = new HashMap<String, ArrayList<JSONObject>>();

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
	}*/


	@Override
	public boolean onChildClick(ExpandableListView parent, View item, int groupPosition, int childPosition, long rowId) {

		if (mSelectedViewId != 0)
		{
			JSONObject aJsonObject = (JSONObject) this.mMapDataChild.get(mlistDataHeader.get(groupPosition)).get(childPosition);
			if (aJsonObject.has("name") )
				try {

					Toast.makeText(this.getActivity(), "player : " + aJsonObject.getString("name"), Toast.LENGTH_SHORT).show();

					mPlayerSelection.onPlayerSelected(mSelectedViewId, aJsonObject);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return true;
	}


}

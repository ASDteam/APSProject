package com.asp.aspproject.coach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	private HashMap<String, List<Player>> mMapDataChild;

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
		mMapDataChild = new HashMap<String, List<Player>>();

		// Adding child data
		mlistDataHeader.add("GoalKeepers");
		mlistDataHeader.add("Defenders");
		mlistDataHeader.add("MidleFielders");
		mlistDataHeader.add("Strikers");

		// Adding child data
		List<Player> GoalKeepers = new ArrayList<Player>();
		Player akeeper1 = new Player();
		akeeper1.setmFirstName("Manuel");
		akeeper1.setmSecondName("Nauer");
		GoalKeepers.add(akeeper1);
		Player akeeper2 = new Player();
		akeeper2.setmFirstName("Ben");
		akeeper2.setmSecondName("ben");
		GoalKeepers.add(akeeper2);


		List<Player> Defenders = new ArrayList<Player>();
		Player aDefender1 = new Player();
		aDefender1.setmFirstName("Alpha");
		aDefender1.setmSecondName("Tig");
		Defenders.add(aDefender1);

		Player aDefender2 = new Player();
		aDefender2.setmFirstName("Pierre");
		aDefender2.setmSecondName("Cabez");
		Defenders.add(aDefender2);

		Player aDefender3 = new Player();
		aDefender3.setmFirstName("The");
		aDefender3.setmSecondName("Beast");
		Defenders.add(aDefender3);

		Player aDefender4 = new Player();
		aDefender4.setmFirstName("Jerene");
		aDefender4.setmSecondName("Tigger");
		Defenders.add(aDefender4);

		List<Player> MidleFielders = new ArrayList<Player>();
		Player aMidleFielder1 = new Player();
		aMidleFielder1.setmFirstName("Arnaud");
		aMidleFielder1.setmSecondName("Schwartz");
		MidleFielders.add(aMidleFielder1);

		Player aMidleFielder2 = new Player();
		aMidleFielder2.setmFirstName("Christopher");
		aMidleFielder2.setmSecondName("Colombus");
		MidleFielders.add(aMidleFielder2);

		Player aMidleFielder3 = new Player();
		aMidleFielder3.setmFirstName("Dony");
		aMidleFielder3.setmSecondName("Betrace");
		MidleFielders.add(aMidleFielder3);

		Player aMidleFielder4 = new Player();
		aMidleFielder4.setmFirstName("John");
		aMidleFielder4.setmSecondName("Labre");
		MidleFielders.add(aMidleFielder4);


		List<Player> Strikers = new ArrayList<Player>();
		Player aStriker1 = new Player();
		aStriker1.setmFirstName("Striker");
		aStriker1.setmSecondName("Force");
		Strikers.add(aStriker1);

		Player aStriker2 = new Player();
		aStriker2.setmFirstName("Carly");
		aStriker2.setmSecondName("Istigo");
		Strikers.add(aStriker2);

		Player aStriker3 = new Player();
		aStriker3.setmFirstName("Steva");
		aStriker3.setmSecondName("Dano");		
		Strikers.add(aStriker3);

		Player aStriker4 = new Player();
		aStriker4.setmFirstName("Boby");
		aStriker4.setmSecondName("Stear");
		Strikers.add(aStriker4);



		mMapDataChild.put(mlistDataHeader.get(0), GoalKeepers); // Header, Child data
		mMapDataChild.put(mlistDataHeader.get(1), Defenders); 
		mMapDataChild.put(mlistDataHeader.get(2), MidleFielders); 
		mMapDataChild.put(mlistDataHeader.get(3), Strikers); 
	}


	@Override
	public boolean onChildClick(ExpandableListView parent, View item, int groupPosition, int childPosition, long rowId) {

		if (mSelectedViewId != 0)
		{
			Player aPlayer = (Player) this.mMapDataChild.get(mlistDataHeader.get(groupPosition)).get(childPosition);
			Toast.makeText(this.getActivity(), "player : " + aPlayer.getmFirstName() + "/" + aPlayer.getmSecondName(), Toast.LENGTH_SHORT).show();

			mPlayerSelection.onPlayerSelected(mSelectedViewId, aPlayer.getmFirstName() + "/" +aPlayer.getmSecondName());
		}
		return true;
	}


}

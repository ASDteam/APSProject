package com.asp.aspproject.coach;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.asp.aspproject.R;
import com.asp.aspproject.request.RequestHandler;
import com.asp.aspproject.utils.Constants;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CoachActivity extends ActionBarActivity implements ActionBar.OnNavigationListener ,  IPositionSelection, IPlayerSelection, OnClickListener {


	private Spinner mSpinner = null;

	private View mActionBarCustomContainer = null;

	private Button mSaveTeamBt = null;

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	private static final String[] SYSTEMS_LIST= {"4-4-2", "4-3-3", "4-5-1","5-4-1",
		"5-3-2", "5-2-3","3-5-2", "3-4-3"};

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coach);

		FragmentManager aFragmentManager = this.getSupportFragmentManager();
		FragmentTransaction aFragmentTransaction = aFragmentManager.beginTransaction();
		PlayersOnPitchFragment aPlayersOnPitchFragment = new PlayersOnPitchFragment();
		aFragmentTransaction.add(R.id.players_on_pitch_container, aPlayersOnPitchFragment, Constants.PLAYERS_ON_PITCH_FRAGMENTTAG);
		aFragmentTransaction.commit();

		String aUrl =  "http://api.geonames.org/findNearbyPostalCodesJSON?postalcode=8775&country=CH&radius=10&username=demo";

		RequestHandler mRequestHandler = new RequestHandler(aUrl, null, this, "getDataResonse", this);
		mRequestHandler.getData();

		// Set up the action bar to show a dropdown list.
		/*final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
				// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(getActionBarThemedContextCompat(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, SYSTEMS_LIST), this);*/


		LayoutInflater inflater = (LayoutInflater) this.getActionBarThemedContextCompat().getSystemService(LAYOUT_INFLATER_SERVICE);

		mActionBarCustomContainer = inflater.inflate(R.layout.action_bar_spinner, null);
		mSpinner = (Spinner) mActionBarCustomContainer.findViewById(R.id.action_bar_spinner_id);
		mSaveTeamBt = (Button) mActionBarCustomContainer.findViewById(R.id.action_bar_save_button);


		ArrayAdapter<String> adapter =	new ArrayAdapter<String>(getActionBarThemedContextCompat(),android.R.layout.simple_list_item_1, android.R.id.text1, SYSTEMS_LIST);
		//adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
		mSpinner.setAdapter(adapter);

		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Do whatever you want with your selected item. You can get it as: parent.getItemAtPosition(position); 
				transmitSystemSelection(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {}
		});

		getActionBar().setIcon(getResources().getDrawable(R.drawable.ic_launcher));//set your actionbar logo
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE );

		LayoutParams layoutParams = new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.RIGHT; // set your layout's gravity to 'right'
		getActionBar().setCustomView(mActionBarCustomContainer, layoutParams);

		mSaveTeamBt.setOnClickListener(this);
	}

	public void getDataResonse(Object object)
	{

		if (object != null)
		{
			Log.e("CoachActivity:getDataResonse", (String)object);
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// do something on back.

			FragmentManager aFragmentManager = this.getSupportFragmentManager();

			if (aFragmentManager.findFragmentByTag(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG) != null && aFragmentManager.findFragmentByTag(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG).isVisible())
			{
				return true;
			}
			else if (aFragmentManager.getBackStackEntryCount() > 0 && aFragmentManager.findFragmentByTag(Constants.PLAYERS_SELECTION_FRAGMENTTAG) != null && aFragmentManager.findFragmentByTag(Constants.PLAYERS_SELECTION_FRAGMENTTAG).isVisible())
			{
				mActionBarCustomContainer.setVisibility(View.VISIBLE);

				/*FragmentTransaction aFragmentTransaction = aFragmentManager.beginTransaction();


				aFragmentTransaction.remove(aFragmentManager.findFragmentByTag(Constants.PLAYERS_SELECTION_FRAGMENTTAG));

				aFragmentManager.popBackStack();

				aFragmentTransaction.commit();
				//aFragmentManager.executePendingTransactions();*/
			}

		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * Backward-compatible version of {@link ActionBar#getThemedContext()} that
	 * simply returns the {@link android.app.Activity} if
	 * <code>getThemedContext</code> is unavailable.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return getActionBar().getThemedContext();
		} else {
			return this;
		}
	}


	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		super.onRestoreInstanceState(savedInstanceState);
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.coach, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {

		transmitSystemSelection(itemPosition);
		return true;

	}

	public void transmitSystemSelection(int iPosition)
	{

		PlayersOnPitchFragment aPlayersOnPitchFragment  = (PlayersOnPitchFragment) this.getSupportFragmentManager().findFragmentByTag(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG);

		aPlayersOnPitchFragment.updateSystemView((SYSTEMS_LIST[iPosition]).replace("-", ""), true);
	}


	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	public void onPosisionSelected(int viewId) {

		// Create fragment and give it an argument for the selected position
		FragmentTransaction aFragmentTransaction = this.getSupportFragmentManager().beginTransaction();

		PlayerSelectionFragment aPlayerSelectionFragment = new PlayerSelectionFragment();
		Bundle args = new Bundle();
		args.putInt(PlayerSelectionFragment.ARG_VIEW_ID, viewId);
		aPlayerSelectionFragment.setArguments(args);

		// Replace whatever is in the fragment_container view with this fragment,
		// and add the transaction to the back stack so the user can navigate back
		aFragmentTransaction.replace(R.id.players_on_pitch_container, aPlayerSelectionFragment, Constants.PLAYERS_SELECTION_FRAGMENTTAG);       

		aFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		aFragmentTransaction.addToBackStack(null);
		// Commit the transaction
		aFragmentTransaction.commit();

		//system selection only available on players on pitch view
		mActionBarCustomContainer.setVisibility(View.GONE);

	}

	@Override
	public void onPlayerSelected(int viewId, String playerName) {

		FragmentTransaction aFragmentTransaction = this.getSupportFragmentManager().beginTransaction();

		PlayersOnPitchFragment aPlayersOnPitchFragment  = (PlayersOnPitchFragment) this.getSupportFragmentManager().findFragmentByTag(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG);		

		aFragmentTransaction.replace(R.id.players_on_pitch_container, aPlayersOnPitchFragment, Constants.PLAYERS_ON_PITCH_FRAGMENTTAG);       

		aFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		// Commit the transaction
		aFragmentTransaction.commit();
		//this.getSupportFragmentManager().executePendingTransactions();

		//aPlayersOnPitchFragment.updateSystemView((SYSTEMS_LIST[mSpinner.getSelectedItemPosition()]).replace("-", ""));

		if (!aPlayersOnPitchFragment.addPlayer(viewId, playerName))
		{
			Toast.makeText(this, playerName + " Already selected", Toast.LENGTH_SHORT).show();
		}

		//system selection only available on players on pitch view
		mActionBarCustomContainer.setVisibility(View.VISIBLE);


	}



	@Override
	public void onClick(View view) {
		switch (view.getId())
		{
		case R.id.action_bar_save_button:
			Toast.makeText(this, "Not yet implemented", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}

	}





}

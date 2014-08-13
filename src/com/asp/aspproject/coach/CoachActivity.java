package com.asp.aspproject.coach;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.asp.aspproject.R;
import com.asp.aspproject.coach.utils.Constants;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CoachActivity extends FragmentActivity implements ActionBar.OnNavigationListener ,  ISystemSelection {

	private ISystemSelection mSystemSelection;

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

		FragmentManager fragmentManager = this.getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		PlayersOnPitchFragment aPlayersOnPitchFragment = new PlayersOnPitchFragment();
		fragmentTransaction.add(R.id.players_on_pitch_container, aPlayersOnPitchFragment, Constants.PLAYERS_ON_PITCH_FRAGMENTTAG);

		fragmentTransaction.commit();

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

		    final View spinnerView = inflater.inflate(R.layout.action_bar_spinner, null);
		    Spinner spinner = (Spinner) spinnerView.findViewById(R.id.action_bar_spinner_id);
		    ArrayAdapter<String> adapter =	new ArrayAdapter<String>(getActionBarThemedContextCompat(),android.R.layout.simple_list_item_1, android.R.id.text1, SYSTEMS_LIST);
		    //adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
		    spinner.setAdapter(adapter);

		    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

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
		    getActionBar().setCustomView(spinnerView, layoutParams);
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
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
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
		try
		{
			//invoke methods of the PlayersOnPitchFragment
			Method aMethod;
			PlayersOnPitchFragment aPlayersOnPitchFragment  = (PlayersOnPitchFragment) this.getSupportFragmentManager().findFragmentByTag(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG);

			String aMethodName = "setView"+ (SYSTEMS_LIST[iPosition]).replace("-", "");
			aMethod = aPlayersOnPitchFragment.getClass().getMethod(aMethodName);

			aMethod.invoke(aPlayersOnPitchFragment);

		} catch (ClassCastException e) {// not that fragment		
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException eNoSuchMethodException) {
			// ...
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onSystemSelected(String iSystem) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onResume() {
		super.onResume();


	}




}

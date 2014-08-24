package com.asp.aspproject.coach;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.asp.aspproject.R;
import com.asp.aspproject.field.SystenField;
import com.asp.aspproject.utils.Constants;

public class PlayersOnPitchFragment extends Fragment implements OnClickListener{

	public static final String CURRENT_SYSTEM = "CURRENT_SYSTEM";


	private IPositionSelection mPositionSelection;


	private TableLayout mTableLayout = null;

	private SystenField mCurrentSysten = null;

	private HashMap<String, Integer> mSelectedPlayers = null;



	public PlayersOnPitchFragment() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.players_on_pitch, container, false);   	

		mTableLayout = (TableLayout) view.findViewById(R.id.players_on_pitch_container_table);

		mCurrentSysten = new SystenField("442");
		
		if (mCurrentSysten !=null)
		{
			updateSystemView(mCurrentSysten.getmSystem(), false);

			if (mSelectedPlayers != null && !mSelectedPlayers.isEmpty())
			{
				for (Entry<String, Integer> entry : mSelectedPlayers.entrySet()) {

					updatePosition(entry.getValue(), entry.getKey());
				} 
			}
		}

		return view;
	}

	@SuppressLint("NewApi")
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
			mPositionSelection = (IPositionSelection) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement ISystemSelection");
		}

		//Log.d("mPositionSelection", mPositionSelection.onSystemSelected(iSystem);)

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}


	public void setView442(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView442");

		mCurrentSysten = new SystenField("442");

		initViews(cleanView);

		int[] a442List = {/*striker */R.id.parent_player00, R.id.parent_player01,
				/*midfielders*/R.id.parent_player10, R.id.parent_player11, R.id.parent_player12, R.id.parent_player13,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22, R.id.parent_player23,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a442List);

		setClickListener();

	}

	public void setView433(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView433");

		mCurrentSysten = new SystenField("433");

		initViews(cleanView);

		int[] a433List = {/*striker */R.id.parent_player00, R.id.parent_player01, R.id.parent_player02,
				/*midfielders*/R.id.parent_player10, R.id.parent_player11, R.id.parent_player12,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22,  R.id.parent_player23,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a433List);

		setClickListener();


	}


	public void setView451(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView451");

		mCurrentSysten = new SystenField("451");

		initViews(cleanView);

		int[] a451List = {/*striker */R.id.parent_player00,
				/*midfielders*/R.id.parent_player10, R.id.parent_player11, R.id.parent_player12, R.id.parent_player13, R.id.parent_player14,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22, R.id.parent_player23,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a451List);

		setClickListener();

	}

	public void setView541(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView541");

		mCurrentSysten = new SystenField("541");

		initViews(cleanView);

		int[] a541List = {/*striker */R.id.parent_player00,
				/*midfielders*/R.id.parent_player10, R.id.parent_player11, R.id.parent_player12, R.id.parent_player13,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22, R.id.parent_player23, R.id.parent_player24,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a541List);

		setClickListener();


	}
	public void setView532(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView532");

		mCurrentSysten = new SystenField("532");

		initViews(cleanView);

		int[] a532List = {/*striker */R.id.parent_player00, R.id.parent_player01,
				/*midfielders*/R.id.parent_player10, R.id.parent_player11, R.id.parent_player12,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22, R.id.parent_player23, R.id.parent_player24,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a532List);

		setClickListener();

	}
	public void setView523(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView523");

		mCurrentSysten = new SystenField("523");

		initViews(cleanView);

		int[] a523List = {/*striker */R.id.parent_player00, R.id.parent_player01,  R.id.parent_player02,
				/*midfielders*/R.id.parent_player10, R.id.parent_player11,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22, R.id.parent_player23, R.id.parent_player24,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a523List);

		setClickListener();
	}

	public void setView343(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView343");

		mCurrentSysten = new SystenField("343");

		initViews(cleanView);

		int[] a343List = {/*striker */R.id.parent_player00, R.id.parent_player01,  R.id.parent_player02,
				/*midfielders*/R.id.parent_player10, R.id.parent_player11, R.id.parent_player12, R.id.parent_player13,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a343List);

		setClickListener();

	}

	public void setView352(boolean cleanView)
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView352");

		initViews(cleanView);

		int[] a352List = {/*striker */R.id.parent_player00, R.id.parent_player01, 
				/*midfielders*/R.id.parent_player10, R.id.parent_player11, R.id.parent_player12, R.id.parent_player13, R.id.parent_player14,
				/*defenders */ R.id.parent_player20, R.id.parent_player21, R.id.parent_player22,
				/*goalkeeper*/R.id.parent_player30};

		makeViewsVisible(a352List);

		setClickListener();

	}



	public void initViews(boolean cleanView){
		
		if (cleanView && mSelectedPlayers !=null)
		{
			mSelectedPlayers.clear();
		}

		for (int rowIndex = 0; rowIndex < mTableLayout.getChildCount(); rowIndex++) {
			View child = mTableLayout.getChildAt(rowIndex);

			if (child instanceof TableRow) {
				TableRow aRow = (TableRow) child;

				for (int playerContaninerIndex = 0; playerContaninerIndex < aRow.getChildCount(); playerContaninerIndex++) {
					View aPlayerContaniner = aRow.getChildAt(playerContaninerIndex);

					if ( aPlayerContaniner instanceof ViewGroup && ((LinearLayout) aPlayerContaniner).getChildCount() > 0)
					{
						View aPlayerView = ((ViewGroup) aPlayerContaniner).getChildAt(0);
						((TextView)aPlayerView.findViewById(R.id.id_player_name)).setText(null);
					}

					aPlayerContaniner.setVisibility(View.GONE);
				}
			}
		}

	}

	public void makeViewsVisible(int[] viewIds){

		for (int rowIndex = 0; rowIndex < mTableLayout.getChildCount(); rowIndex++) {
			View child = mTableLayout.getChildAt(rowIndex);

			if (child instanceof TableRow) {
				TableRow aRow = (TableRow) child;

				for (int playerContaninerIndex = 0; playerContaninerIndex < aRow.getChildCount(); playerContaninerIndex++) {
					View aPlayerContaniner = aRow.getChildAt(playerContaninerIndex);
					for (int visibleViewIndex = 0; visibleViewIndex < viewIds.length; visibleViewIndex++) 
					{
						if (viewIds[visibleViewIndex] == aPlayerContaniner.getId())
						{
							aPlayerContaniner.setVisibility(View.VISIBLE);
							break;

						}

					}
				}
			}
		}


	}


	public void setClickListener()
	{

		for (int rowIndex = 0; rowIndex < mTableLayout.getChildCount(); rowIndex++) {
			View child = mTableLayout.getChildAt(rowIndex);

			if (child instanceof TableRow) {
				TableRow aRow = (TableRow) child;

				for (int playerContaninerIndex = 0; playerContaninerIndex < aRow.getChildCount(); playerContaninerIndex++) {
					View aPlayerContaniner = aRow.getChildAt(playerContaninerIndex);

					if (aPlayerContaniner.getVisibility() == View.VISIBLE && aPlayerContaniner instanceof ViewGroup && ((LinearLayout) aPlayerContaniner).getChildCount() > 0)
					{
						View aPlayerView = ((ViewGroup) aPlayerContaniner).getChildAt(0);
						aPlayerView.setOnClickListener(this);
					}
				}
			}
		}

	}

	@Override
	public void onClick(View view) {

		//Toast.makeText(PlayersOnPitchFragment.this.getActivity(), "view : " + view.getId(), Toast.LENGTH_SHORT).show();
		mPositionSelection.onPosisionSelected(view.getId());
	}

	public void updatePosition(int viewId, String playerName)
	{

		for (int rowIndex = 0; rowIndex < mTableLayout.getChildCount(); rowIndex++) {
			View child = mTableLayout.getChildAt(rowIndex);

			if (child instanceof TableRow) {
				TableRow aRow = (TableRow) child;

				for (int playerContaninerIndex = 0; playerContaninerIndex < aRow.getChildCount(); playerContaninerIndex++) {
					View aPlayerContaniner = aRow.getChildAt(playerContaninerIndex);
					if (aPlayerContaniner.getVisibility() == View.VISIBLE && aPlayerContaniner instanceof ViewGroup && ((LinearLayout) aPlayerContaniner).getChildCount() > 0)
					{
						View aPlayerView = ((ViewGroup) aPlayerContaniner).getChildAt(0);
						if (viewId == aPlayerView.getId())
						{
							((TextView)aPlayerView.findViewById(R.id.id_player_name)).setText(playerName);
							break;
						}
					}
				}
			}

		}

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current current system choice.
		super.onSaveInstanceState(outState);
		if (mCurrentSysten != null)
		{
			outState.putString(CURRENT_SYSTEM, mCurrentSysten.getmSystem());
		}
	}

	public void updateSystemView(String system, boolean cleanViews)
	{
		try
		{
			//invoke methods of the PlayersOnPitchFragment
			Method aMethod;

			String aMethodName = "setView"+ system;
			aMethod = this.getClass().getMethod(aMethodName, boolean.class);

			aMethod.invoke(this, cleanViews);

		} catch (ClassCastException e) {// not that fragment		
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public boolean addPlayer(int viewId, String playerName)
	{
		if (mSelectedPlayers == null)
		{
			mSelectedPlayers = new HashMap<String, Integer>();
		}
		
		for (Entry<String, Integer> entry : mSelectedPlayers.entrySet()) {

			if (entry.getValue() == viewId)
			{
				//if viewId exist in map => second click on the same view
				mSelectedPlayers.remove(entry.getKey());
				break;
			}
			
		} 

		if (!mSelectedPlayers.containsKey(playerName))
		{
			mSelectedPlayers.put(playerName,viewId);
			return true;
		}
		else
		{			
			return false;
		}

	}




}





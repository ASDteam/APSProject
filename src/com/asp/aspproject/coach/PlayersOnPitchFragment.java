package com.asp.aspproject.coach;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.asp.aspproject.R;
import com.asp.aspproject.field.SystenField;
import com.asp.aspproject.models.PlayerSelection;
import com.asp.aspproject.utils.Constants;

public class PlayersOnPitchFragment extends Fragment implements OnClickListener{

	public static final String CURRENT_SYSTEM = "CURRENT_SYSTEM";


	private IPositionSelection mPositionSelection;


	private TableLayout mTableLayout = null;

	private SystenField mCurrentSysten = null;

	private PlayerSelection mPlayerSelection= null;

	private HashMap<Integer, JSONObject> mSelectedPlayers = null;



	public PlayersOnPitchFragment() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle=  getArguments(); 

		if (bundle != null)
		{
			if ( bundle.containsKey(CURRENT_SYSTEM))
			{
				mCurrentSysten = new SystenField(bundle.getString(CURRENT_SYSTEM));
				mPlayerSelection = new PlayerSelection(mCurrentSysten);

			}
		}



	}


	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.players_on_pitch, container, false);   	

		mTableLayout = (TableLayout) view.findViewById(R.id.players_on_pitch_container_table);

		if (mCurrentSysten != null)
		{
			updateSystemView(mCurrentSysten.getmSystem(), false);

			if (mSelectedPlayers != null && !mSelectedPlayers.isEmpty())
			{
				for (Entry<Integer, JSONObject> entry : mSelectedPlayers.entrySet()) {

					updatePosition(entry.getKey(), entry.getValue());
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

		mCurrentSysten.setmSystem("442");
		mPlayerSelection.init442();

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

		mCurrentSysten.setmSystem("433");
		mPlayerSelection.init433();

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

		mCurrentSysten.setmSystem("451");
		mPlayerSelection.init451();

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

		mCurrentSysten.setmSystem("541");
		mPlayerSelection.init541();

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

		mCurrentSysten.setmSystem("532");
		mPlayerSelection.init532();

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

		mCurrentSysten.setmSystem("523");		
		mPlayerSelection.init523();

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

		mCurrentSysten.setmSystem("343");
		mPlayerSelection.init343();

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

		mCurrentSysten.setmSystem("352");
		mPlayerSelection.init352();

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
		mPositionSelection.onPosisionSelected(view.getId(), mPlayerSelection.getmPositions().get(view.getId()));
	}

	public void updatePosition(int viewId, JSONObject player)
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
							String playerName = null;
							int playerMalus = 0;

							if (player.has("name"))
							{
								try {

									playerName = player.getString("name");

									if ((playerName.split(" ")).length > 0)
									{
										playerName = playerName.split(" ")[1];
									}


									JSONObject aProfiles = (JSONObject)player.get("profile");

									Iterator<?> keys = aProfiles.keys();

									while( keys.hasNext() ){
										String key = (String)keys.next();
										if( aProfiles.get(key) instanceof JSONObject ){
											JSONObject aProfile = (JSONObject)aProfiles.get(key);
											if (aProfile.has("malus"))
											{
												playerMalus = aProfile.getInt("malus");

											}
										}
									}
									if (playerName != null)
									{
										((TextView)aPlayerView.findViewById(R.id.id_player_name)).setText(Html.fromHtml(playerName));
										
										TextView textView = ((TextView)aPlayerView.findViewById(R.id.id_player_malus));
										
										if (playerMalus != 0)
										{
											textView.setVisibility(View.VISIBLE);
											textView.setText(this.getString(R.string.malus) + " " + playerMalus);										

										}
										else
										{
											textView.setVisibility(View.GONE);
										}
										break;
									}
								} catch (JSONException e) {
									e.printStackTrace();
								}
							}
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

	public boolean addPlayer(int viewId, JSONObject player)
	{
		if (mSelectedPlayers == null)
		{
			mSelectedPlayers = new HashMap<Integer, JSONObject>();
		}

		for (Entry<Integer, JSONObject> entry : mSelectedPlayers.entrySet()) {

			//if the player to add already exist -> return false

			JSONObject existingPlayer = entry.getValue();
			try {
				if (existingPlayer.has("name") && player.has("name")
						&& existingPlayer.getString("name").equals(player.getString("name")))
				{
					return false;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} 


		if (mSelectedPlayers.containsKey(viewId))
		{
			//if viewId exist in map => second click on the same view
			mSelectedPlayers.remove(viewId);
		}

		mSelectedPlayers.put(viewId, player);
		return true;

	}




}





package com.asp.aspproject.coach;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.asp.aspproject.R;
import com.asp.aspproject.coach.utils.Constants;

public class PlayersOnPitchFragment extends Fragment{

	private ISystemSelection mSystemSelection;

	//stricker
	private View mContainerPlayer00 = null;
	private View mContainerPlayer01 = null;
	private View mContainerPlayer02 = null;
	private View mContainerPlayer03 = null;
	private View mContainerPlayer04 = null;

	//middlefielders
	private View mContainerPlayer10 = null;
	private View mContainerPlayer11 = null;
	private View mContainerPlayer12 = null;
	private View mContainerPlayer13 = null;
	private View mContainerPlayer14 = null;

	//defenders
	private View mContainerPlayer20 = null;
	private View mContainerPlayer21 = null;
	private View mContainerPlayer22 = null;
	private View mContainerPlayer23 = null;
	private View mContainerPlayer24 = null;

	//goalkeeper
	private View mContainerPlayer30 = null;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.players_on_pitch, container, false);   	
		
		mContainerPlayer00 =  view.findViewById(R.id.parent_player00);
		mContainerPlayer01 =  view.findViewById(R.id.parent_player01);
		mContainerPlayer02 =  view.findViewById(R.id.parent_player02);
		mContainerPlayer03 =  view.findViewById(R.id.parent_player03);
		mContainerPlayer04 =  view.findViewById(R.id.parent_player04);
		
		mContainerPlayer10 =  view.findViewById(R.id.parent_player10);
		mContainerPlayer11 =  view.findViewById(R.id.parent_player11);
		mContainerPlayer12 =  view.findViewById(R.id.parent_player12);
		mContainerPlayer13 =  view.findViewById(R.id.parent_player13);
		mContainerPlayer14 =  view.findViewById(R.id.parent_player14);
		
		mContainerPlayer20 =  view.findViewById(R.id.parent_player20);
		mContainerPlayer21 =  view.findViewById(R.id.parent_player21);
		mContainerPlayer22 =  view.findViewById(R.id.parent_player22);
		mContainerPlayer23 =  view.findViewById(R.id.parent_player23);
		mContainerPlayer24 =  view.findViewById(R.id.parent_player24);
		
		
		
		mContainerPlayer30 =  view.findViewById(R.id.parent_player30);
		/*mContainerPlayer30.findViewById(R.id.player30).setOnClickListener(new View.OnClickListener() {
	
			public void onClick(View v) {
				Toast.makeText(PlayersOnPitchFragment.this.getActivity(), "player30 ", Toast.LENGTH_LONG);
				
			}
		});
		
		mContainerPlayer30.setOnClickListener(new View.OnClickListener() {
	
			public void onClick(View v) {
				Toast.makeText(PlayersOnPitchFragment.this.getActivity(), "mContainerPlayer30 ", Toast.LENGTH_LONG);
				
			}
		});*/
		
		
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
			mSystemSelection = (ISystemSelection) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement ISystemSelection");
		}

		//Log.d("mSystemSelection", mSystemSelection.onSystemSelected(iSystem);)

	}

	public void setView442()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView442");
		
		init();
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		mContainerPlayer02.setVisibility(View.GONE); 
		
		//midfielders
		mContainerPlayer10.setVisibility(View.GONE);
		
		//defenders
		mContainerPlayer20.setVisibility(View.GONE);


	}

	public void setView433()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView433");
		
		init();
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		
		//midfielders
		mContainerPlayer10.setVisibility(View.GONE);
		mContainerPlayer11.setVisibility(View.GONE);
		
		//defenders
		mContainerPlayer20.setVisibility(View.GONE);

	}


	public void setView451()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView451");
		init();
		
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		mContainerPlayer02.setVisibility(View.GONE); 
		mContainerPlayer03.setVisibility(View.GONE); 
	
		
		//defenders
		mContainerPlayer20.setVisibility(View.GONE);

	}

	public void setView541()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView541");

		init();
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		mContainerPlayer02.setVisibility(View.GONE); 
		mContainerPlayer03.setVisibility(View.GONE);

		//midfielders
		mContainerPlayer10.setVisibility(View.GONE);


	}
	public void setView532()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView532");
		init();
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		mContainerPlayer02.setVisibility(View.GONE); 
		
		//midfielders
		mContainerPlayer10.setVisibility(View.GONE);
		mContainerPlayer11.setVisibility(View.GONE);


	}
	public void setView523()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView523");
		init();
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		
		//midfielders
		mContainerPlayer10.setVisibility(View.GONE);
		mContainerPlayer11.setVisibility(View.GONE);
		mContainerPlayer12.setVisibility(View.GONE);
		


	}

	public void setView343()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView343");
		init();
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		
		//midfielders
		mContainerPlayer10.setVisibility(View.GONE);
		
		//defenders
		mContainerPlayer20.setVisibility(View.GONE);
		mContainerPlayer21.setVisibility(View.GONE);

	}

	public void setView352()
	{
		Log.d(Constants.PLAYERS_ON_PITCH_FRAGMENTTAG, "setView352");
		init();
		//striker
		mContainerPlayer00.setVisibility(View.GONE); 
		mContainerPlayer01.setVisibility(View.GONE); 
		mContainerPlayer02.setVisibility(View.GONE);

		//defenders
		mContainerPlayer20.setVisibility(View.GONE);
		mContainerPlayer21.setVisibility(View.GONE);

	}


	
	public void init(){
		
		mContainerPlayer00.setVisibility(View.VISIBLE);
		mContainerPlayer01.setVisibility(View.VISIBLE);
		mContainerPlayer02.setVisibility(View.VISIBLE);
		mContainerPlayer03.setVisibility(View.VISIBLE);
		mContainerPlayer04.setVisibility(View.VISIBLE);
		
		mContainerPlayer10.setVisibility(View.VISIBLE);
		mContainerPlayer11.setVisibility(View.VISIBLE);
		mContainerPlayer12.setVisibility(View.VISIBLE);
		mContainerPlayer13.setVisibility(View.VISIBLE);
		mContainerPlayer14.setVisibility(View.VISIBLE);
		
		mContainerPlayer20.setVisibility(View.VISIBLE);
		mContainerPlayer21.setVisibility(View.VISIBLE);
		mContainerPlayer22 .setVisibility(View.VISIBLE);
		mContainerPlayer23.setVisibility(View.VISIBLE);
		mContainerPlayer24.setVisibility(View.VISIBLE);
		
		
		
		mContainerPlayer30.setVisibility(View.VISIBLE);
		
	}



}

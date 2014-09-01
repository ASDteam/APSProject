package com.asp.aspproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.asp.aspproject.coach.CoachActivity;
import com.asp.aspproject.request.RequestHandler;
import com.asp.aspproject.utils.Constants.CACHE_KEY;

public class SplashActivity extends Activity {


	private RequestHandler mRequestHandler = null;


	private static final long SPLASHTIME = 3000;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.activity_splash);


		
		String aUrl =  "http://192.168.1.18:3000";

		//mRequestHandler = new RequestHandler(aUrl, null, this, "getDataCompleted", this, CACHE_KEY.FILE_PLAYER_LIST_KEY);
		//mRequestHandler.getData();
		



		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent mainIntent = new Intent(SplashActivity.this, CoachActivity.class);
				startActivity(mainIntent);
				finish();
			}
		}, SPLASHTIME);
	}

	public void getDataCompleted (Object object)
	{
		Intent mainIntent = new Intent(SplashActivity.this, CoachActivity.class);
		startActivity(mainIntent);
		finish();		
	}
	

}

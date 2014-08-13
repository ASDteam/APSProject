package com.asp.aspproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.asp.aspproject.coach.CoachActivity;

public class SplashActivity extends Activity {


	
	private static final long SPLASHTIME = 3000;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.activity_splash);




		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent mainIntent = new Intent(SplashActivity.this, CoachActivity.class);
				startActivity(mainIntent);
				finish();
			}
		}, SPLASHTIME);
	}


}

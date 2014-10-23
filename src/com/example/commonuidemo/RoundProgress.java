package com.example.commonuidemo;

import android.app.Activity;
import android.os.Bundle;

public class RoundProgress extends Activity {
	
	private RoundProgressBar roundProgressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_round_progress);
	}
	
	
	private void initProgress(){
		roundProgressBar = (RoundProgressBar)findViewById(R.id.roundProgressBar);
	}
	
	
	private void onSetProgress() {
	}
	
	
	
}

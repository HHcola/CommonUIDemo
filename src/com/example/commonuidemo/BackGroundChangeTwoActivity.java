package com.example.commonuidemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BackGroundChangeTwoActivity extends Activity {
	private final static String TAG = BackGroundChangeActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.background_change_two);
	}
	
}

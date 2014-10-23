package com.example.commonuidemo;

import android.app.Activity;  
import android.content.Intent;
import android.os.Bundle;  
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
  
public class InterceptTouchStudyActivity extends Activity {
    static final String TAG = "ITSActivity";
    TextView tv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_activity_main);
     }
 }
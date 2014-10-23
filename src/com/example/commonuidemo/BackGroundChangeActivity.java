package com.example.commonuidemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BackGroundChangeActivity extends Activity {
	private final static String TAG = BackGroundChangeActivity.class.getSimpleName();
	
	private Button mChangeBtn;
	private View   mBackGroundLayout;
	private boolean mChangeBg = true;
	private ViewStub mViewStubSearch;
	private ViewStub mViewStubSearchBox;
	private View  mViewSearch;
	private View  mSearchBox;
	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.background_change);
		mContext = this;
		onInitUI();
	}
	
	private void onInitUI() {
		mBackGroundLayout = findViewById(R.id.backgrouond_change_layout);
		
		mChangeBtn = (Button) findViewById(R.id.change_background_btn);
		mChangeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mChangeBg) {
					Log.d(TAG, "onClick Change BackGround");
					Intent intent = new Intent(mContext, BackGroundChangeTwoActivity.class);
					mContext.startActivity(intent);
					
//					mBackGroundLayout.setBackground(getResources().getDrawable(R.drawable.navigation_bar_bg));
//					if (mSearchBox == null) {
//						mSearchBox = mViewStubSearchBox.inflate();
//					}
//					mSearchBox.setVisibility(View.VISIBLE);
//					if(mViewSearch != null) {
//						mViewSearch.setVisibility(View.GONE);
//					}

					mChangeBg = false;
				} else {
					Log.d(TAG, "onClick Change to Color");
//					mBackGroundLayout.setBackgroundColor(getResources().getColor(R.color.color_navigation_bar_bg));
//					if (mViewSearch == null) {
//						mViewSearch = mViewStubSearch.inflate();
//					}
//					mViewSearch.setVisibility(View.VISIBLE);
//					if (mSearchBox != null) {
//						mSearchBox.setVisibility(View.GONE);
//					}
					mChangeBg = true;
				}
				
			}
		});
		
		
		mViewStubSearch = (ViewStub)findViewById(R.id.viewstub_search);
		mViewStubSearchBox = (ViewStub)findViewById(R.id.viewstub_search_box);
		
	}
}

package com.example.commonuidemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.slider.BannerSliderActivity;

public class MainActivity extends FragmentActivity {

	private final static String TAG = MainActivity.class.getSimpleName();
	
	private Context mContext;
	
	private Fragment  mFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_main);
		initUI();
	}

	/**
	 * 初始化UI
	 */
	private void initUI(){
		onSetTestObject(R.id.round_progress_btn, RoundProgress.class);
		onSetTestObject(R.id.touch_test_btn, InterceptTouchStudyActivity.class);
		onSetTestObject(R.id.banner_slider_test_btn, BannerSliderActivity.class);
		onSetTestObject(R.id.drawable_transition, DrawableTransitionActivity.class);
		onSetTestObject(R.id.my_custom_test, MyCustomActivity.class);
		onSetTestObject(R.id.my_custom_layout, LayoutCustomActivity.class);
		
		onSetTestObject(R.id.my_custom_listview, ListViewActivity.class);
		onSetTestObject(R.id.my_custom_fragment_listview, SlidingListViewActivity.class);
		onSetTestObject(R.id.my_under_line_indeator, UnderLinePageActivity.class);
		onSetTestObject(R.id.my_change_bg, BackGroundChangeActivity.class);
		onSetTestObject(R.id.my_web_view, WebViewMoreActivity.class);
		onSetTestObject(R.id.my_web_view_single, WebViewActivity.class);
        onSetTestObject(R.id.my_dynamic_change,
                DynamicChangeControlsActivity.class);
//		mFragment = new ListViewFragment();
	}
	
	
	private void onSetTestObject(int resID, final Class<?> cls ) {
		final Button touchTest = (Button)findViewById(resID);
		if (touchTest != null) {
			touchTest.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(mContext,cls);
					mContext.startActivity(intent);
				}
			});
		}
	}
	

	
}

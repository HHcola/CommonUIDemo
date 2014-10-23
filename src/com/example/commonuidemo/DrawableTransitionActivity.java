package com.example.commonuidemo;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DrawableTransitionActivity extends Activity {

	private final static String TAG = DrawableTransitionActivity.class.getSimpleName();
	private ImageView backgroundIv;
	private final static int  SET_BACKGROUDN_TO_ORIGIN = 1;
	private View  backgroundView;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transition_view);
		backgroundIv = (ImageView)findViewById(R.id.iv_background);
		backgroundView = (FrameLayout)findViewById(R.id.fl_background);
		onSetBackGround();
	}
	
	private void onSetBackGround() {
		handler.sendEmptyMessageDelayed(SET_BACKGROUDN_TO_ORIGIN, 3000);
	}
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			
			switch (msg.what) {
			case SET_BACKGROUDN_TO_ORIGIN:
				onSetBackgroundToOrigin();
				break;

			default:
				break;
			}
		}
	};
	
	private void onSetBackgroundToOrigin() {
		TransitionDrawable transition =   (TransitionDrawable) getResources().getDrawable(R.drawable.drawable_transition);  
		backgroundIv.setBackground(transition);  
		transition.startTransition(3000);  
	}

}

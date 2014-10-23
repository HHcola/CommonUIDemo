package com.example.commonuidemo;

import java.util.Timer;
import java.util.TimerTask;

import com.example.common.widget.UnderlinePageIndicator;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class UnderLinePageActivity extends Activity {

	private final static String TAG = UnderLinePageActivity.class.getSimpleName();
	
	private UnderlinePageIndicator mPageIndicator;
	private Timer timer;
	private PageChangeTimeTask pageChangeTimeTask;
	final private  int  CHANTE_PAGE_MSG  = 1;
	private Handler mHandler;
	final private long mPeriod = 3*1000;
	private int mCurrentPageIndex = 0;
	final private int mTotalPageSize = 4;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_underline_page);
		setUnderLinePageInit();
	}
	
	private void setUnderLinePageInit() {
		
		mPageIndicator = (UnderlinePageIndicator)findViewById(R.id.underline_page_indicator);
		if (mPageIndicator == null) {
			Log.d(TAG, "setUnderLinePage Error : mPageIndicator is NULL");
			return ;
		}
		
		initHandler();
		
		mPageIndicator.setTotalUnderLinePage(mTotalPageSize);
		mPageIndicator.setCurrentUnderLinePage(mCurrentPageIndex);
		mPageIndicator.setUnderLineDrawable(getResources().getDrawable(R.drawable.ic_banner_indicator));
		
		pageChangeTimeTask = new PageChangeTimeTask();
		pageChangeTimeTask.setHandler(mHandler);
		pageChangeTimeTask.setMsg(CHANTE_PAGE_MSG);
		timer = new Timer();
		timer.schedule(pageChangeTimeTask, 0, mPeriod);
		
}

private void initHandler() {
		mHandler = new Handler(Looper.getMainLooper()) {
			@Override
			public void handleMessage(android.os.Message msg) {

				switch (msg.what) {
				case CHANTE_PAGE_MSG:
				    Log.d(TAG, "handleMessage");
					mPageIndicator.setCurrentUnderLinePage(mCurrentPageIndex);
					mCurrentPageIndex ++;
					if (mCurrentPageIndex >= mTotalPageSize) {
						mCurrentPageIndex = 0;
					}
					break;

				default:
					break;
				}
			}

		};
	}

}


class PageChangeTimeTask extends TimerTask {

	private Handler mHandler;
	private int mMsg;
	@Override
	public void run() {
		if (mHandler != null) {
		    
			mHandler.sendEmptyMessage(mMsg);
		}
		
	}
	
	public void setHandler(Handler handler) {
		mHandler = handler;
	}
	
	public void setMsg(int msg) {
		mMsg = msg;
	}
}
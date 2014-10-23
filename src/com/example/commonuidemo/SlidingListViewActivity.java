package com.example.commonuidemo;

import com.example.common.SlidingUpPanelLayout;
import com.example.common.SlidingUpPanelLayout.PanelSlideListener;
import com.example.commonuidemo.ListViewFragment.ListViewPopupFragmentListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;

public class SlidingListViewActivity extends FragmentActivity implements
ListViewPopupFragmentListener{
	private ListViewFragment  mFragment;
    private SlidingUpPanelLayout mPanel;
    private FragmentManager mFragmentMgr;
    private boolean mIsExpand;
    private ViewStub mViewStub;
    private ViewGroup mParentView;
    private boolean mIsDestoryed;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidinglistviewactivity);
		initUI();
	}

	private void initUI(){
		mFragment = new ListViewFragment();
		mFragmentMgr = this.getSupportFragmentManager();
		mViewStub = (ViewStub)findViewById(R.id.offline_stub);
		mViewStub.setOnInflateListener(new InflateListener());
		mParentView = (ViewGroup)findViewById(R.id.parent_viewstub);
		loadData();
	}
	
	
    public void removeViewStub() {
    	if (mViewStub == null) return;
    	
    	mParentView.removeView(mViewStub);
    	mViewStub = null;
    }
    private void loadFragment() {
    	if (mIsDestoryed) return;
		mFragmentMgr.beginTransaction()
		.add(R.id.offline_slideContent, mFragment,"ListViewFragment")
		.commitAllowingStateLoss();
    }
    
    class InflateListener implements OnInflateListener {

		@Override
		public void onInflate(ViewStub stub, View inflated) {
			// TODO Auto-generated method stub
		    mPanel = (SlidingUpPanelLayout)inflated;
		    initPanel();
		    loadFragment();
		}
    	
    }
    
    /**
     * init panel
     */
    private void initPanel() {
        mPanel.setPanelSlideListener(new PanelSlideListener() {

			@Override
			public void onPanelSlide(View panel, float slideOffset) {
				
			}

			@Override
			public void onPanelCollapsed(View panel) {
			    removeOfflineFragment();
			    removeViewStub();
			}

			@Override
			public void onPanelExpanded(View panel) {
			   mPanel.setSlidingEnabled(true);
			   mIsExpand = true;
			}

			@Override
			public void onPanelAnchored(View panel) {
				
			}
        	
        });
    }
 private void removeOfflineFragment() {
    	
    	Fragment offlineFragment = mFragment;
    	if (offlineFragment == null) {
    		return;
    	}
    	
    	mFragmentMgr.beginTransaction()
    	.remove(offlineFragment)
    	.commitAllowingStateLoss();
    	
    	removeViewFromParent(mPanel);
    }
    
    private void removeViewFromParent(View v) {
    	ViewGroup parentGroup = (ViewGroup)v.getParent();
    	if (parentGroup == null) {
    		return;
    	}
    	parentGroup.removeView(v);
    }
    
    public boolean isExpaned() {
    	return mIsExpand;
    }
    
    public void expand() {
    	if (mIsExpand) return;
    	mPanel.setSlidingEnabled(false);
    	mPanel.expandPane();
    }
    
    
    public void collapse() {
    	if (!mIsExpand) return;
    	mIsExpand = false;
    	mPanel.collapsePane();
    }
    
    private void loadData() {
    	mFragment.setListener(this);
		mFragment.getHandler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
			 if (mIsDestoryed) {
				 return ;
			 }
			 if (mViewStub == null) {
				 return ;
			 }
			 mViewStub.inflate();
			}
		}, 1000);
		
    }
    
	@Override
	public void onViewCreated() {
	       // 设置触摸时，可以拖动的view
		mPanel.setDragView(mFragment.getDragView());
		// expand
		expand();
	}

	@Override
	public void onLoadDataSuess() {
		// TODO Auto-generated method stub
		
	}
    
}

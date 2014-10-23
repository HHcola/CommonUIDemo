package com.example.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class CustomLayout extends ViewGroup {

	final static String TAG = CustomView.class.getSimpleName();
	
	public CustomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setWillNotDraw(false);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (getChildCount() > 0) {
			Log.d(TAG, "onMeasure Child ");
			View childView = getChildAt(0);
			measureChild(childView, widthMeasureSpec, heightMeasureSpec);
		}
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		if (getChildCount() > 0) {
			Log.d(TAG, "onLayout Child ");
			View childView = getChildAt(0);
			childView.layout(0, 0, childView.getMeasuredWidth(), childView.getMeasuredHeight());
		}
	}

	/**
	 * 测试layout是否调用draw 当viewgroup设置background时，才会调用draw
	 */
	@Override
	public void draw(Canvas canvas) { 
		if (getChildCount() > 0) {
			Log.d(TAG, "draw child ----");
			for(int i  = 0; i < getChildCount(); i ++) {
				View childView = getChildAt(i);
				childView.draw(canvas);
			}
		}
		
		super.draw(canvas);
	}
	
	
	@Override
    public void onDraw(Canvas canvas) {  
	   Log.i(TAG, " onDraw -----");
       canvas.save();     
       Paint paint  = new Paint();
       paint.setTextSize(16);
       paint.setColor(Color.YELLOW);
       canvas.drawText("自定义View", 0, 30, paint);    
       canvas.restore();
   }
	
}
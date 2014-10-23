package com.example.commonuidemo;

import android.widget.TextView;

import android.content.Context;  
import android.util.AttributeSet;  
import android.util.Log;  
import android.view.MotionEvent;  
import android.view.View;
  
public class MyTextView extends TextView {

    private final String TAG = "MyTextView";

    public MyTextView(Context context, AttributeSet attrs) {
       super(context, attrs);
       Log.d(TAG,TAG);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        int action = event.getAction();
//        switch(action){
//        case MotionEvent.ACTION_DOWN:
//             Log.d(TAG,"dispatchTouchEvent action:ACTION_DOWN");
//             break;
//        case MotionEvent.ACTION_MOVE:
//             Log.d(TAG,"dispatchTouchEvent action:ACTION_MOVE");
//             break;
//        case MotionEvent.ACTION_UP:
//             Log.d(TAG,"dispatchTouchEvent action:ACTION_UP");
//             break;
//        case MotionEvent.ACTION_CANCEL:
//             Log.d(TAG,"dispatchTouchEvent action:ACTION_CANCEL");
//             break;
//        }
//        return true;	
//    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
       int action = ev.getAction();
       switch(action){
       case MotionEvent.ACTION_DOWN:
           Log.d(TAG,"onTouchEvent action:ACTION_DOWN");
           break;
       case MotionEvent.ACTION_MOVE:
           Log.d(TAG,"onTouchEvent action:ACTION_MOVE");
           break;
       case MotionEvent.ACTION_UP:
           Log.d(TAG,"onTouchEvent action:ACTION_UP");
           break;
       case MotionEvent.ACTION_CANCEL:
           Log.d(TAG,"onTouchEvent action:ACTION_CANCEL");
           break;
       }

       return false; 
    }

    public void onClick(View v) {
       Log.d(TAG, "onClick");
    }

    public boolean onLongClick(View v) {
       Log.d(TAG, "onLongClick");
       return false;
    }
}
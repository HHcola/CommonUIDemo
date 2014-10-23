package com.example.commonuidemo;

import com.example.custom.view.CustomView;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyCustomActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    

//        LinearLayout ll  =  new LinearLayout(MyCustomActivity.this);
//        CustomView customView = new CustomView(MyCustomActivity.this); 
//        //简单设置为 width 200px - height 100px吧 
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(200 , 100);
//        customView.setLayoutParams(lp);
//        //需要将该View设置为可点击/触摸状态，否则触摸该View没有效果。
//        customView.setClickable(true);
//        
//        ll.addView(customView);
//        setContentView(ll); 
        setContentView(R.layout.custom_activity);
    }
}

package com.example.commonuidemo;

import com.example.common.Zhang;
import com.example.listview.ListAdapter;

import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {
	private final static String[] data = {"张飞","张辽","张角","张三丰","张牙舞爪","张灯结彩","张唑啉","张大民"};
	
	//创建数据源.  
    Zhang[] data2 = new Zhang[]{  
        new Zhang("张飞",38,"zhangfei@gmail.com","燕山"),  
        new Zhang("张辽",36,"zhangliao@sina.com","雁门"),  
        new Zhang("张角",51,"zhangjiao@gmail.com","钜鹿"),  
        new Zhang("张三丰",200,"sanfeng@gmail.com","辽东"),  
        new Zhang("张牙舞爪",25,"5zhao@gmail.com","冀州"),
        new Zhang("张灯结彩",25,"5zhao@gmail.com","冀州") ,
        new Zhang("张唑啉",25,"5zhao@gmail.com","冀州") ,
        new Zhang("张大民",25,"5zhao@gmail.com","冀州") ,
        new Zhang("张牙舞爪",25,"5zhao@gmail.com","冀州")  
    };  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);
        
        ListView listview = (ListView)findViewById(R.id.listview);
        /*
         * 第一种：普通字符串
         */
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_list_item_1,data);
        
        /*
         * 第二种：文艺类对象
         */
        ArrayAdapter<Zhang> adapter2 = new ArrayAdapter<Zhang>(this, 
        		android.R.layout.simple_list_item_1,data2);
        
        /*
         * 第三种：自定义适配器
         */
        ListAdapter adapter3 = new ListAdapter(this, R.layout.listview,data2) ;
        
        listview.setAdapter(adapter3);
    }
}
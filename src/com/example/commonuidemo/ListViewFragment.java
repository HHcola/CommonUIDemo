package com.example.commonuidemo;

import com.example.common.Zhang;
import com.example.listview.ListAdapter;

import android.R.anim;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewFragment extends Fragment {
	private final static String[] data = {"张飞","张辽","张角","张三丰","张牙舞爪","张灯结彩","张唑啉","张大民"};
	private ListViewPopupFragmentListener mListener;
	private TextView  textView;
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
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	View v = inflater.inflate(R.layout.list_view_layout, null);
    	setupView(v);
    	return v;
    }
    
    public void setListViewHeightBasedOnChildren(ListView listView) {
        android.widget.ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	super.onViewCreated(view, savedInstanceState);
    	if (mListener != null) {
    		mListener.onViewCreated();
    	}
    }
    private void setupView(View rootView) {
        ListView listview = (ListView)rootView.findViewById(R.id.listview);
        /*
         * 第一种：普通字符串
         */
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), 
        		android.R.layout.simple_list_item_1,data);
        
        /*
         * 第二种：文艺类对象
         */
        ArrayAdapter<Zhang> adapter2 = new ArrayAdapter<Zhang>(getActivity(), 
        		android.R.layout.simple_list_item_1,data2);
        
        /*
         * 第三种：自定义适配器
         */
        ListAdapter adapter3 = new ListAdapter(getActivity(), R.layout.listview,data2) ;
        
        listview.setAdapter(adapter3);
//        setListViewHeightBasedOnChildren(listview);
        textView = (TextView)rootView.findViewById(R.id.listview_header);
    }
    
    public void setListener(ListViewPopupFragmentListener listener) {
    	mListener = listener;
    }
    
    public View getDragView() {
    	return textView; 
    }
    
    public Handler mHandler = new Handler();
    
	public Handler getHandler() {
		return mHandler;
	}
	
	public static interface ListViewPopupFragmentListener {
		void onViewCreated();
		
		void onLoadDataSuess();
	}
}

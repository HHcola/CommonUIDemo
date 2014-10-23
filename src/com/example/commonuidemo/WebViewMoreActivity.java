package com.example.commonuidemo;


import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.TextView;

public class WebViewMoreActivity extends Activity implements OnClickListener{

	private final static String TAG = WebViewMoreActivity.class.getSimpleName();
	
	private WebView webView;
	private TextView mUninstallTextView;
	private TextView mInstallTextView;
	private TextView mUpdateTextView;
	
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.webview_activity);
        initUI();
    }
    
    private void initUI() {
    	mUninstallTextView = (TextView) findViewById(R.id.web_view_how_uninstall_title);
    	mInstallTextView = (TextView)findViewById(R.id.web_view_how_install_title);
    	mUpdateTextView = (TextView)findViewById(R.id.web_view_how_update_title);
    	
    	mUninstallTextView.setOnClickListener(this);
    	mInstallTextView.setOnClickListener(this);
    	mUpdateTextView.setOnClickListener(this);
    	
    }
    
    
    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(int webViewID, String strUrl) {
        webView = (WebView) findViewById(webViewID);
        webView.getSettings().setAllowFileAccess(true); // 允许访问文件
//        webView.getSettings().setBuiltInZoomControls(true); // 设置显示缩放按钮
//        webView.getSettings().setSupportZoom(true); //支持缩放
        webView.getSettings().setUseWideViewPort(true) ;
        webView.getSettings().setLoadWithOverviewMode(true) ;
        webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN) ;
        webView.getSettings().setJavaScriptEnabled(true);
        loadData(strUrl);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d(TAG, "onPageStarted url" + url);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "onPageFinished url" + url);
            }
            @Override
            public void onReceivedError (WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode,description,failingUrl);
                Log.d(TAG, "onReceivedError url" + failingUrl + " Error Code = " + errorCode + " Description : " + description);
            }
            @Override
            public boolean shouldOverrideUrlLoading (WebView view, String url) {
            	Log.d(TAG, "shouldOverrideUrlLoading url" + url);
                return false;
            }
        });

    }
    
    
    private void loadData(String strUrl) {
    	if (webView == null) {
    		return ;
    	}
    	
    	Log.d(TAG, "loadData url" + strUrl);
    	webView.loadUrl(strUrl);
    }

    private void onClickUninstall() {
       final boolean isShow = findViewById(R.id.web_view_uninstall).isShown();	
       findViewById(R.id.web_view_uninstall).setVisibility(isShow ? View.GONE : View.VISIBLE);
       if (!isShow) {
           initWebView(R.id.web_view_uninstall,"http://cp01-rdqa-dev132.cp01.baidu.com:8088/faq.html?support=mobile&_branch=en");
       }
    }
    
    private void onClickInstall() {
        final boolean isShow = findViewById(R.id.web_view_install).isShown();	
        findViewById(R.id.web_view_install).setVisibility(isShow ? View.GONE : View.VISIBLE);
        if (!isShow) {
            initWebView(R.id.web_view_install,"http://www.163.com");
        }
    }
    
    private void onClickUpdate() {
        final boolean isShow = findViewById(R.id.web_view_update).isShown();	
        findViewById(R.id.web_view_update).setVisibility(isShow ? View.GONE : View.VISIBLE);
        if (!isShow) {
            initWebView(R.id.web_view_update,"http://www.sina.com");
        }
    }
    
    
	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
		case R.id.web_view_how_uninstall_title:
			onClickUninstall();
			break;
			
		case R.id.web_view_how_install_title:
			onClickInstall();
			break;
			
		case R.id.web_view_how_update_title:
			onClickUpdate();
			break;
		default:
			Log.d(TAG, "onClick unknown id error");
			break;
		}
	}
}

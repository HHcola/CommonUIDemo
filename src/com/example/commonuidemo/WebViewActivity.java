package com.example.commonuidemo;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EncodingUtils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {

	private static final String TAG = WebViewActivity.class.getSimpleName();
	private static final String URL = "http://cp01-rdqa-dev132.cp01.baidu.com:8088/faq.html?support=mobile&_branch=en";
//	private static final String URL = "http://cp01-rdqa-dev132.cp01.baidu.com:8088/faq.html?";
	private WebView webView;
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.single_web_view_activity);
        initUI();
//        final String strUrl = encodeUrl(URL);
        loadData(URL);
//        loadDataByPost(URL);
//        postData(URL,"support=mobile&_branch=en");
    }
    
    private void initUI() {
    	initWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        webView = (WebView) findViewById(R.id.web_view_test);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d(TAG, "onPageStarted : url " + url);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "onPageFinished : url " + url);
            }
            @Override
            public void onReceivedError (WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode,description,failingUrl);
                Log.d(TAG, "onReceivedError : failingUrl" + failingUrl);
            }
            @Override
            public boolean shouldOverrideUrlLoading (WebView view, String url) {
            	Log.d(TAG, "shouldOverrideUrlLoading : url" + url);
                return false;
            }
        });

        
        
    }
    
    private String encodeUrl(String strUrl) {
    	
    	StringBuffer buffer=new StringBuffer(strUrl);
    	buffer.append(URLEncoder.encode("support=") + URLEncoder.encode("mobile"));
    	buffer.append(URLEncoder.encode("&_branch=") + URLEncoder.encode("en"));
    	return buffer.toString();
    	
    }
    private void loadData(String strUrl) {
    	if (webView == null) {
    		return ;
    	}
    	
    	
    	Log.d(TAG, "loadData url" + strUrl);
    	webView.loadUrl(strUrl);
    }

    private void loadDataByPost(final String strUrl){
    	webView.loadData("<html></html>", "text/html", "UTF-8");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
            	webView.loadUrl(strUrl);

            }
        }, 500);
    }
    
    protected String addLocationToUrl(String url){
        if(!url.endsWith("?"))
            url += "?";

        List<NameValuePair> params = new LinkedList<NameValuePair>();

        params.add(new BasicNameValuePair("support", "mobile"));
        params.add(new BasicNameValuePair("_branch", "en"));

        String paramString = URLEncodedUtils.format(params, "utf-8");

        url += paramString;
        return url;
    }
    
    private void postData(String strUrl, String postData) {
    	if (webView == null) {
    		return ;
    	}
    	
    	Log.d(TAG, "postData url" + strUrl);
//    	try {
//			webView.postUrl(strUrl, postData.getBytes("UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	Log.d("fff", addLocationToUrl(strUrl));
    	webView.loadUrl(addLocationToUrl(strUrl));
    }
    
    private void loadDataWithBaseURL(String strUrl) {
    	
    }
}

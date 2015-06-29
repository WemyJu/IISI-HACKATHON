package com.firsttry.firsttry;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;

import com.firsttry.firsttry.json.Constants;

public class MyHistory extends Fragment {
    ImageView my_history_btn, weather_repo_btn, add_health_btn, share_pos_btn;
    WebView webView;

    public MyHistory(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_history, container, false);

        webView = (WebView)rootView.findViewById(R.id.webView2);
        // 開啟執行JavaScript功能
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(Constants.API_MY_HISTORY_URL);

        my_history_btn = (ImageView)rootView.findViewById(R.id.my_history_btn);
        my_history_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                webView.loadUrl(Constants.API_MY_HISTORY_URL);
            }
        });
        weather_repo_btn = (ImageView)rootView.findViewById(R.id.weather_repo_btn);
        weather_repo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                webView.loadUrl(Constants.API_MY_WEATHER_REPO_URL);
            }
        });
        add_health_btn = (ImageView)rootView.findViewById(R.id.add_health_info_btn);
        add_health_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                webView.loadUrl(Constants.API_SHARE_POS_URL);
            }
        });
        share_pos_btn = (ImageView)rootView.findViewById(R.id.share_pos_btn);
        share_pos_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // TODO Auto-generated method stub
                webView.loadUrl(Constants.API_HOSPITAL_URL);
            }
        });
        return rootView;
    }
}

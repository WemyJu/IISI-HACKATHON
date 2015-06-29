package com.firsttry.firsttry;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;

import com.firsttry.firsttry.json.Constants;

public class HealthInfo extends Fragment {
    WebView webView;
    ImageView add_health_btn;



    public HealthInfo(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_health_info, container, false);

        webView = (WebView)rootView.findViewById(R.id.webView2);
        // 開啟執行JavaScript功能
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(Constants.API_SHARE_POS_URL);

        add_health_btn = (ImageView)rootView.findViewById(R.id.add_health_btn);
        add_health_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                 }
        });
        return rootView;
    }
}

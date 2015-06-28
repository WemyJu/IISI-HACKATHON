package com.firsttry.firsttry;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firsttry.firsttry.json.Constants;

public class CheckProgress extends Fragment {
    ProgressBar myProgressBar;
    String progressMinValue, progressMaxValue;
    SharedPreferences mSharedPreferences;
    TextView progress_str;
    ImageView my_progress_btn, health_info_btn;

    public CheckProgress(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_check_progress, container, false);

        mSharedPreferences = getActivity().getSharedPreferences(Constants.PREFERENCE_NAME, 0);
        progressMinValue = mSharedPreferences.getString("progressMinValue", "20");
        progressMaxValue = mSharedPreferences.getString("progressMaxValue", "80");

        progress_str = (TextView) rootView.findViewById(R.id.mission_per);
        if(progressMinValue==null || progressMaxValue == null)
            progress_str.setText("挑戰");
        else
            progress_str.setText(progressMaxValue+"%");

        myProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        myProgressBar.setProgress(Integer.valueOf(progressMaxValue));

        my_progress_btn = (ImageView)rootView.findViewById(R.id.my_progress_btn);
        my_progress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                MyHistory nextFrag= new MyHistory();
                CheckProgress.this.getFragmentManager().beginTransaction()
                        .replace(R.id.container, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });
        health_info_btn = (ImageView)rootView.findViewById(R.id.health_info_btn);
        health_info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                HealthInfo nextFrag= new HealthInfo();
                CheckProgress.this.getFragmentManager().beginTransaction()
                        .replace(R.id.container, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }


}

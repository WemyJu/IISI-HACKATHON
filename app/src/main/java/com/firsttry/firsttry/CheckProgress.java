package com.firsttry.firsttry;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firsttry.firsttry.json.Constants;

public class CheckProgress extends Fragment {
    ProgressBar myProgressBar;
    String progressMinValue, progressMaxValue;
    SharedPreferences mSharedPreferences;
    TextView progress_str;

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
        //myProgressBar.setProgress(Integer.valueOf(progressMaxValue));
        myProgressBar.setProgress(70);

        return rootView;
    }


}

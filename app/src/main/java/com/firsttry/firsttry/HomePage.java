package com.firsttry.firsttry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.util.LogWriter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firsttry.firsttry.json.Constants;


public class HomePage extends ActionBarActivity {
    SharedPreferences mSharedPreferences;
    String task, days;
    TextView start_btn;
    EditText task_et, days_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mSharedPreferences = this.getSharedPreferences(Constants.PREFERENCE_NAME, 0);
        task = mSharedPreferences.getString("task", "");
        days = mSharedPreferences.getString("days", "");
        Log.w(task, days);
        if(task != null && days != null && !task.isEmpty() && days.isEmpty()) {
            Intent it = new Intent(HomePage.this, MainActivity.class);
            startActivity(it);
        }

        task_et = (EditText)findViewById(R.id.task_et);
        days_et = (EditText)findViewById(R.id.days_et);
        start_btn = (TextView) findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                task = task_et.getText().toString();
                days = days_et.getText().toString();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString("task", task)
                        .putString("days", days)
                        .commit();

                Intent it = new Intent(HomePage.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

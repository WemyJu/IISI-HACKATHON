package com.firsttry.firsttry;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class LoginPage extends ActionBarActivity {
    /*********************************************************************************/
    // debug
    public static final String TAG = "MainActivity";

    public static final boolean D = true;

    public float startTime;

    /*********************************************************************************/
    // global tools
    SharedPreferences mSharedPreferences;

    /*********************************************************************************/
    // parse data
    ArrayList<String> mGet1, mGet2, mGet3;
    ArrayList<HashMap<String, String>> list;
    String id, pw, result;

    /*********************************************************************************/
    // UI
    ProgressDialog alertProgress;
    AlertDialog.Builder searchMsg;
    ImageButton login_btn;
    EditText id_et, pw_et;
    /*********************************************************************************/
    // Lifecycle
    /*********************************************************************************/
    // Static
    //LeaveStatAdapter mAdapter;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mSharedPreferences = this.getSharedPreferences(Constants.PREFERENCE_NAME, 0);
        id = mSharedPreferences.getString("id", "");
        pw = mSharedPreferences.getString("pw", "");

        //AlearProgress
        alertProgress = new ProgressDialog(LoginPage.this);
        alertProgress.setMessage("登入中~請稍後......");
        alertProgress.setCancelable(false);

        /*if(login(id, pw)){
            Intent it = new Intent(LoginPage.this, MainActivity.class);
            startActivity(it);
        }*/
        id_et = (EditText) findViewById(R.id.id_editText);
        pw_et = (EditText) findViewById(R.id.pw_editText);
        login_btn = (ImageButton) this.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                id = id_et.getText().toString();
                pw = pw_et.getText().toString();
                Log.w(id, " "+pw);
                if(id!=null && pw!=null) {
                    //if (login(id, pw)) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putString("id", "jingfei")
                                .putString("pw", "jingfei")
                                .commit();
                        /*editor.putString("id", id)
                                .putString("pw", id)
                                .commit();*/
                        Intent it = new Intent(LoginPage.this, MainActivity.class);
                        startActivity(it);
                    //}
                }
            }
        });

        alertProgress.dismiss();
    }

    boolean login(String id, String pw){
        Log.w(TAG, "getMain ");
        alertProgress.show();
        Appaction.get().getApi().api_getMain(id, pw, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {
                if (D) {
                    Log.w(TAG, "response = " + response);
                }
                alertProgress.dismiss();
                try {
                    result = response.getString("result");
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                final AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);    //顯示於主程式main
                builder.setTitle("網路連線出現問題，請連絡客服人員");    //加入標題
                builder.setMessage(error.getMessage());    //加入說明
                builder.setPositiveButton("我知道了",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
//						MainActivity.this.finish();
                            }
                        }
                );
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        builder.show();
                    }
                });
            }
        });
        if(result.equals("yes")){
            return true;
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if(result.equals("no user"))
                builder.setMessage("Unregister user");
            else if(result.equals("wrong password"))
                builder.setMessage("Wrong user id or wrong password");
            builder.setCancelable(false);
            AlertDialog alert = builder.create();
            alert.show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_page, menu);
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

package com.firsttry.firsttry.json;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mac on 15/6/27.
 */
public class Web_Service {
    ///////////////////////////////////////////
    // debug
    ///////////////////////////////////////////

    public static final String TAG = Web_Service.class.getSimpleName();

    public static final boolean D = true;
    public static final boolean D_API_CONTENT_STATE       = D && true;
    public static final boolean D_API_CONTENT_TIME       = D && false;
    public static final boolean D_API_CONTENT            = D && false;
    public static final boolean D_API_ACTIVITY_FUTURE    = D && true;
    public static final boolean D_API_SIGNACTIVITY_QUERY = D && false;
    public static final boolean D_API_SIGNACTIVITY       = D && false;
    public static final boolean D_API_EUSER_NEW          = D && false;
    public static final boolean D_API_EUSER_LOGIN        = D && false;
    public static final boolean D_API_EUSER_DATA         = D && false;
    public static final boolean D_API_EUSER_UPDATE       = D && false;
    public static final boolean D_API_ACTIVITYGAME_PRIZE = D && false;
    public static final boolean D_API_ACTIVITYGAME_GAMESTATE  = D && false;
    public static final boolean D_API_ACTIVITY_GAME_SET_ANS   = D && false;
    public static final boolean D_API_ACTIVITYGAME_AWARDPRIZE = D && false;

    private final RequestQueue mQueue;

    public Web_Service(RequestQueue queue) {
        mQueue = queue;
    }
    public Request<?> api_getMain(String id, String pw, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {

        String uri = String.format(Constants.API_URL);

        if(D_API_ACTIVITY_FUTURE) {
            Log.w(TAG, "api uri = " + uri);
        }
        Log.w("in ", "api_getMain");
        Log.w("id ", id);
        Log.w("pw ", pw);
        ArrayList<BasicNameValuePair> params = new ArrayList();

        PostParameterJsonObjectRequest jsonObjectRequest = new PostParameterJsonObjectRequest(Request.Method.POST, uri , params, listener, errorListener) ;
        params.add(new BasicNameValuePair("id", id));
        params.add(new BasicNameValuePair("pw", pw));
        return mQueue.add(jsonObjectRequest);
    }
}

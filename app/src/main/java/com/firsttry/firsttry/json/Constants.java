package com.firsttry.firsttry.json;

/**
 * Created by mac on 15/6/27.
 */
public class Constants {
    //APPVer
    public static final int APPVer = 2;


    public static final int VERSION = 1;
    public static final int SECONDS = 1000;
    public static final int MINUTES = 60 * 1000;
    public static final int HOURS = 60 * MINUTES;
    public static final int DAYS = 24 * HOURS;

    //Life flow control
    public static final int KILL_YOURSELF = 4444;
    public static final int KILL_ALLAPP = 8888;

    //RetryPolicy
    public static final int MY_SOCKET_TIMEOUT_MS = 1;
    public static final int MY_SOCKET_MAX_RETRIES = 1;
    public static final float MY_SOCKET_BACKOFF_MULT = 1.0f;

    //Customize by yourself
    public static final String PREFERENCE_NAME = "FirstTryPreference"; /* the name of the preference */
    //public static final String DB_NAME = "template-db";
    //public static final String IMG_FOLDER_NAME = "download";
    public static final String HOST = "http://192.168.206.111/FirstTry";

    //API uri
    public static final String API_MY_HISTORY_URL = HOST+"/map2";
    public static final String API_MY_WEATHER_REPO_URL = HOST+"/xml";
    public static final String API_SHARE_POS_URL = HOST+"/health";
    public static final String API_LOGIN_URL = HOST+"/login";
}

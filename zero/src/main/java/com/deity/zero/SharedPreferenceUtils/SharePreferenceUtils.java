package com.deity.zero.SharedPreferenceUtils;

import android.content.Context;
import android.content.SharedPreferences;

import com.deity.zero.data.Params;

/**
 * 偏好设置
 * Created by Deity on 2016/4/7.
 */
public class SharePreferenceUtils {

    public void readInt(Context context,String key,int defValue){
        SharedPreferences preferences = context.getSharedPreferences(Params.APP_NAME,Context.MODE_PRIVATE);
        preferences.getInt(key,defValue);
    }

    public void readInt(Context context,String key){
        readInt(context, key, 0);
    }

    public void readStr(Context context,String key,String defValue){
        SharedPreferences preferences = context.getSharedPreferences(Params.APP_NAME,Context.MODE_PRIVATE);
        preferences.getString(key, defValue);
    }

    public void readStr(Context context,String key){
        readStr(context, key);
    }

    public void readBoolean(Context context,String key,boolean defValue){
        SharedPreferences preferences = context.getSharedPreferences(Params.APP_NAME,Context.MODE_PRIVATE);
        preferences.getBoolean(key, defValue);
    }

    public void readBoolean(Context context,String key){
        readBoolean(context, key, false);
    }


    public void write(Context context,String key,int value){
        SharedPreferences preferences = context.getSharedPreferences(Params.APP_NAME,Context.MODE_PRIVATE);
        preferences.edit().putInt(key,value).apply();
    }

    public void write(Context context,String key,String value){
        SharedPreferences preferences = context.getSharedPreferences(Params.APP_NAME,Context.MODE_PRIVATE);
        preferences.edit().putString(key, value).apply();
    }

    public void write(Context context,String key,boolean value){
        SharedPreferences preferences = context.getSharedPreferences(Params.APP_NAME,Context.MODE_PRIVATE);
        preferences.edit().putBoolean(key, value).apply();
    }


}

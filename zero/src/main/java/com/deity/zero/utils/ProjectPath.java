package com.deity.zero.utils;

import android.os.Environment;

/**
 * 这是应用的一些目录地址
 * Created by Deity on 2016/4/7.
 */
@SuppressWarnings("ALL")
public class ProjectPath {

    /**获取SD卡的目录*/
    public void getSDRoot(){
        Environment.getExternalStorageDirectory();
    }
}

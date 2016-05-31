package com.deity.zero.utils;

import android.graphics.Bitmap;
import android.view.View;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 屏幕截图功能:主要就是利用SDK提供的View.getDrawingCache()方法
 * 使用方法:
 * 直接在View上android:onclick="getScreenShot"
 * <p/>
 * Created by fengwenhua on 2016/5/31.
 */
public class ScreenShotUtils {

    public void getScreenShot(View v) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        String fname = "/sdcard/" + sdf.format(new Date()) + ".png";
        View view = v.getRootView();

        view.setDrawingCacheEnabled(true);

        view.buildDrawingCache();

        Bitmap bitmap = view.getDrawingCache();

        if (bitmap != null) {

            System.out.println("bitmap got !");

            try {

                FileOutputStream out = new FileOutputStream(fname);

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);

                System.out.println("file" + fname + "output done.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("bitmap is NULL !");
        }

    }

}

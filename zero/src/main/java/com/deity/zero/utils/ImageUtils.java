package com.deity.zero.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.nio.Buffer;

/**
 * Created by fengwenhua on 2016/6/3.
 */
public class ImageUtils {
    private static final String TAG = ImageUtils.class.getSimpleName();
    private BitmapFactory.Options options;

    public static ImageUtils instance;

    private ImageUtils(){
        initBitmapOptions();
    };

    public static ImageUtils getInstance(){
        if (null==instance){
            synchronized (ImageUtils.class){
                if (null==instance){
                    instance = new ImageUtils();
                }
            }
        }
        return instance;
    }

    public BitmapFactory.Options initBitmapOptions(){
        Log.e(TAG,"init bitmap options");
        options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//只解析头文件，不加载Bitmap
        return options;
    }

    /**
     * 获取文件的宽高比
     * @param imageUrl 只能是本地图片的local地址
     * @return
     */
    public float getRatio(String imageUrl){
        Bitmap bitmapTmp = BitmapFactory.decodeFile(imageUrl,options);
        ImageSpec imageSpec = new ImageSpec();
        imageSpec.setImageHeight(bitmapTmp.getHeight());
        imageSpec.setImageWidth(bitmapTmp.getWidth());
        return imageSpec.setRatio();
    }

    public class ImageSpec{

        private float imageWidth;

        private float imageHeight;

        public float getImageWidth() {
            return imageWidth;
        }

        public void setImageWidth(float imageWidth) {
            this.imageWidth = imageWidth;
        }

        public float getImageHeight() {
            return imageHeight;
        }

        public void setImageHeight(float imageHeight) {
            this.imageHeight = imageHeight;
        }

        public float setRatio(){
            if (0f!=imageHeight){
                return imageWidth/imageHeight;
            }
            return 0f;
        }
    }
}

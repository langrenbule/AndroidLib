package com.deity.customview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 自适应宽高比的ImageView控件
 * Created by fengwenhua on 2016/6/3.
 */
public class AutoAdaptionImage extends ImageView{

    public AutoAdaptionImage(Context context) {
        /**如果有自定义的属性 this(context,null)*/
        super(context);
    }

    public AutoAdaptionImage(Context context, AttributeSet attrs) {
        /**如果有自定义的属性 this(context,attrs,0)*/
        super(context, attrs);
    }

    public AutoAdaptionImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /***
     * 如果宽度是EXACTLY(充满或已确定)
     * @param widthMeasureSpec 来自父控件的宽度
     * @param heightMeasureSpec 来自父控件的高度
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int height=MeasureSpec.getSize(heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int width=MeasureSpec.getSize(widthMeasureSpec);
//        if (heightMode==MeasureSpec.EXACTLY&&widthMode!=MeasureSpec.EXACTLY)
        /**是否保持宽高比。需要与maxWidth、MaxHeight一起使用，否则单独使用没有效果?*/
        setAdjustViewBounds(true);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

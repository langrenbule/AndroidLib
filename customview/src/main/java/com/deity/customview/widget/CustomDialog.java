package com.deity.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.deity.customview.R;

/**
 * Created by fengwenhua on 2016/5/30.
 */
public class CustomDialog extends View {
    private float radius = 0f;

    /**构造一
     * 构造一调用构造二方法
     * */
    public CustomDialog(Context context) {
        super(context);
    }

    /***
     * 构造二
     * 构造二调用构造三方法
     * @param context
     * @param attrs
     */
    public CustomDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 构造三
     * 在构造三获取自定义属性，则应用不管调用哪个构造函数，都将成功获取到自定义属性
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CustomDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //其中attrs是View已经自定的属性，比如android:layout_width
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.custom_dialog);
        radius = typedArray.getFloat(R.styleable.custom_dialog_radius,5.0f);
        typedArray.recycle();//记得要释放资源
    }

}

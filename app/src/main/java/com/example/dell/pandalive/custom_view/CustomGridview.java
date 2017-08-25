package com.example.dell.pandalive.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by dell on 2017/8/25.
 */

public class CustomGridview extends GridView {


    public CustomGridview(Context context) {
        super(context);
    }

    public CustomGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec  = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

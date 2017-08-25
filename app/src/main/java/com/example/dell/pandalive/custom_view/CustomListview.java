package com.example.dell.pandalive.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by dell on 2017/8/25.
 */

public class CustomListview extends ListView {
    public CustomListview(Context context) {
        super(context);
    }

    public CustomListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

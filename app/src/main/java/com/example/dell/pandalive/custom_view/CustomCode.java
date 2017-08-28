package com.example.dell.pandalive.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.dell.pandalive.R;

import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by dell on 2017/7/7.
 */

public class CustomCode extends View{

    String mtext;
    int mcolor;
    int msize;
    private Paint paint;
    int radio=100;
    float x=100;
    float y=100;
    private Rect rect;

    public CustomCode(Context context, AttributeSet attrs) {
        this(context, attrs, 0);


    }


    public CustomCode(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "onClick: "+mtext );
                mtext = randomtext();
                postInvalidate();
            }
        });


        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Myview, defStyleAttr, 0);

        for (int i = 0; i < a.getIndexCount(); i++) {

            int attr = a.getIndex(i);

            switch (attr) {
                case R.styleable.Myview_my_text:

                    mtext = a.getString(attr);

                    break;
                case R.styleable.Myview_text_color:

                    mcolor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.Myview_text_size:

                    msize =  a.getDimensionPixelSize(attr,(int)TypedValue.applyDimension(
                       TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));

                    break;
            }
        }

        a.recycle();

        paint = new Paint();
        paint.setTextSize(msize);
        rect = new Rect();
        paint.getTextBounds(mtext,0,mtext.length(),rect);


    }

    private String randomtext(){


        Random random = new Random();

        ArrayList<Integer> arr = new ArrayList<>();
        while (arr.size() < 4) {

            int rt = random.nextInt(10);
            arr.add(rt);
        }

        StringBuffer sb = new StringBuffer();

        for (Integer i : arr) {

            sb.append("" + i);
        }


        return sb.toString();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(x,y,radio,paint);

        paint.setColor(Color.DKGRAY);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);

        paint.setColor(mcolor);

        canvas.drawText(mtext,getWidth()/2-rect.width()/2,getHeight()/2+rect.height()/2,paint);


        // 获取到自定义的view宽高
        final int height = getHeight();
        final int width = getWidth();
        // 绘制小圆点
        int[] point;
        paint.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            point = getPoint(height, width);
            /**
             * drawCircle (float cx, float cy, float radius, Paint paint)
             * float cx：圆心的x坐标。
             * float cy：圆心的y坐标。
             * float radius：圆的半径。
             * Paint paint：绘制时所使用的画笔。
             */
            canvas.drawCircle(point[0], point[1], 1, paint)

            ;
        }

        paint.setColor(Color.GREEN);
        int [] line;
        for(int i = 0; i < 100; i ++)
        {
            line = getLine(height, width);
            /**
             * startX：起始端点的X坐标。
             *startY：起始端点的Y坐标。
             *stopX：终止端点的X坐标。
             *stopY：终止端点的Y坐标。
             *paint：绘制直线所使用的画笔。
             */
            canvas.drawLine(line[0], line[1], line[2], line[3], paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

//                x = event.getX();
//                y = event.getY();
//                radio += 10;
//                invalidate();
                break;
            case MotionEvent.ACTION_DOWN:

                Log.e(TAG, "onClick: "+mtext );
                mtext = randomtext();
                postInvalidate();

                break;
        }


        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int withSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int with;
        int height;

        if (withMode == MeasureSpec.EXACTLY) {
            with = withSize;
        } else {

            paint.setTextSize(msize);
            paint.getTextBounds(mtext,0,mtext.length(),rect);
            float textwith = rect.width();
            int desried = (int) (getPaddingLeft() + textwith + getPaddingRight());
            with = desried;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            paint.setTextSize(msize);
            paint.getTextBounds(mtext, 0, mtext.length(), rect);
            float textheight = rect.height();
            int desried = (int) (getPaddingTop() + textheight + getPaddingBottom());
            height = desried;
        }

        setMeasuredDimension(with, height);

    }
    public  int[] getLine(int height, int width)
    {
        int [] tempCheckNum = {0,0,0,0};
        for(int i = 0; i < 4; i+=2)
        {
            tempCheckNum[i] = (int) (Math.random() * width);
            tempCheckNum[i + 1] = (int) (Math.random() * height);
        }
        return tempCheckNum;
    }

    private int[] getPoint(int height, int width) {
        int[] tempCheckNum = {0, 0, 0, 0};
        tempCheckNum[0] = (int) (Math.random() * width);
        tempCheckNum[1] = (int) (Math.random() * height);
        return tempCheckNum;
    }

}

package com.example.togglebutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author jianxin on 2018/6/27.
 */
public class CustomViewGroup extends ViewGroup {

    private Paint mPaint;

    public CustomViewGroup(Context context) {
        this(context,null);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //将所有子view进行测量，measureChild()是测量单个子view
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //获取viewGroup测量模式，测量值
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(0,0);
        } else if (wMode == MeasureSpec.AT_MOST && hMode == MeasureSpec.AT_MOST) {
            //如果宽高都是wrap_content
            int maxHeight = getMaxMesasureHeight();
            int maxMesureWidth = getMaxMesureWidth();
            setMeasuredDimension(maxMesureWidth,maxHeight);
        } else if (wMode == MeasureSpec.AT_MOST) {
            int maxMesureWidth = getMaxMesureWidth();
            setMeasuredDimension(maxMesureWidth,hSize);
        } else if (hMode == MeasureSpec.AT_MOST) {
            int maxHeight = getMaxMesasureHeight();
            setMeasuredDimension(wSize,maxHeight);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int currentHeight = t;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            childView.layout(l,currentHeight,l + childView.getMeasuredWidth(),currentHeight + childView.getMeasuredHeight());
            currentHeight += childView.getMeasuredHeight();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        canvas.drawRect(getLeft(),getTop(),getLeft()+getMaxMesureWidth(),getTop()+getMaxMesasureHeight(),mPaint);

    }

    public int getMaxMesasureHeight() {
        int childCount = getChildCount();
        int maxMesasureHeight = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            maxMesasureHeight += childView.getMeasuredHeight();
        }
        return maxMesasureHeight;
    }

    private int getMaxMesureWidth() {
        int childCount = getChildCount();
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getMeasuredWidth() > maxWidth) {
                maxWidth = childView.getMeasuredWidth();
            }
        }
        return maxWidth;
    }
}

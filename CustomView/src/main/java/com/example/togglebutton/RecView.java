package com.example.togglebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author jianxin on 2018/6/27.
 */
public class RecView extends View {

    private int defultSize;
    private Paint mPaint;

    public RecView(Context context) {
        this(context,null);
    }

    public RecView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RecView);
        defultSize = (int) typedArray.getDimension(R.styleable.RecView_defultSize, 200);
        typedArray.recycle();
    }

    public RecView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int wSize = getSize(defultSize, widthMeasureSpec);
        int hSize = getSize(defultSize, heightMeasureSpec);
        if (wSize < hSize) {
            hSize = wSize;
        } else {
            wSize = hSize;
        }
        setMeasuredDimension(wSize,hSize);
    }

    public int getSize(int defultSize, int measureSpac) {
        int mSize = defultSize;
        //父类传递给子类的测量模式
        int mode = MeasureSpec.getMode(measureSpac);
        //父类传递给子类的测量值
        int size = MeasureSpec.getSize(measureSpac);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                mSize = defultSize;
                break;
            case MeasureSpec.EXACTLY: //相当于match_parent 或者 固定值（100dp）
                mSize = size;
                break;
            case MeasureSpec.AT_MOST:  //wrap_parent
                mSize = defultSize;
                break;
        }
        return mSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = getMeasuredWidth()/2;
        //圆心的横坐标为控件的左边起始位置加上半径
        int centerX = getLeft() + r;
        int centerY = getTop() + r;

        mPaint.setColor(Color.RED);
        canvas.drawCircle(centerX,centerY,r,mPaint);
    }
}
